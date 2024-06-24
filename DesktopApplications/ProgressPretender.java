package DesktopApplications;

import javax.swing.JLabel;
import javax.swing.*;

public class ProgressPretender implements Runnable {
    JLabel label;
    int progress;

    public ProgressPretender(JLabel label) {
        this.label = label;
        progress = 0;
    }

    public void run() {
        while (progress <= 100) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    label.setText(progress + "%");
                }
            });

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                System.err.println("Someone interrupted us. Skipping download.");
                break;
            }

            progress++;
        }
    }
}

//     public void run() {
//         while (progress <= 100) {
//             SwingUtilities.invokeLater(new Runnable()
//             {
//             public void run()
//             {
//             label.setText(progress + "%");
//             }
//             });

//             try {
//                 Thread.sleep(1000);
//             } catch (InterruptedException ie) {
//                 System.err.println("Someone interrupted us. Skipping download.");
//                 break;
//             }

//             progress++;
//         }
// }

// still works the same?

/*
 * Thread Safety:
 * 
 * With SwingUtilities.invokeLater(): The label is updated on the EDT, ensuring
 * that the GUI component changes are thread-safe. This adheres to Swing’s
 * single-threaded rule, preventing potential race conditions and inconsistent
 * UI states.
 * Without SwingUtilities.invokeLater(): The label is updated directly from the
 * worker thread. This violates Swing's threading model, as Swing components
 * should only be accessed and modified on the EDT. While it might work in
 * simple cases, it introduces the risk of threading issues and undefined
 * behavior, especially as the application scales or becomes more complex.
 * UI Responsiveness and Stability:
 * 
 * With SwingUtilities.invokeLater(): The method allows for the GUI to remain
 * responsive. By scheduling the update to the label on the EDT, it ensures that
 * the UI can process other events concurrently and updates are executed
 * smoothly.
 * Without SwingUtilities.invokeLater(): Updating the label directly on the
 * worker thread can cause the UI to become unresponsive if other threads are
 * also interacting with the GUI. It can lead to a poor user experience,
 * especially if the updates are frequent or if there are multiple threads
 * involved.
 * Code Maintenance and Scalability:
 * 
 * With SwingUtilities.invokeLater(): This approach scales well as it adheres to
 * best practices for Swing programming. It ensures that all UI updates are
 * managed in a single, predictable thread, making it easier to debug and extend
 * the application.
 * Without SwingUtilities.invokeLater(): As the application grows, directly
 * updating the UI from multiple threads can become difficult to manage and
 * debug. It can lead to complex threading issues that are hard to diagnose and
 * fix.
 * 
 * Why SwingUtilities.invokeLater() is Preferred:
 * Swing is Not Thread-Safe: Swing components should be manipulated only on the
 * EDT to avoid inconsistencies and potential crashes.
 * Predictable Behavior: Using SwingUtilities.invokeLater() ensures that the UI
 * updates are handled in a consistent and predictable manner.
 * Best Practices: It aligns with the recommended practices for Swing
 * development, making the code robust and maintainable.
 */