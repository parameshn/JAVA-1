package DesktopApplications;

/* Threading Considerations
 If you have read any of the JDK documentation on Swing as you’ve been working
 through this chapter, you may have come across the warning that Swing components
 are not thread safe. If you recall from Chapter 9, Java supports multiple threads of
 execution to take advantage of modern computer processing power. One of the con
cerns about multithreaded applications is that two threads might fight over the same 

resource or update the same variable at the same time but with different values. Not
 knowing if your data is correct can severely impact your ability to debug a program
 or even just trust its output. For Swing components, this warning is reminding you
 that your UI elements are subject to this type of corruption.
 To help maintain a consistent UI, Swing encourages you to update your components
 on the AWT event dispatch thread. This is the thread that naturally handles things like
 button clicks. If you update a component in response to an event (such as our counter
 example in “Action Events” on page 322 above), you are set. The idea is that if every
 other thread in your application sends UI updates to the event dispatch thread, no
 component can be adversely affected by simultaneous, possibly conflicting changes.
 A common example of when threading is front and center in graphical applications is
 the “long-running task.” Think of downloading a file from the cloud while an anima
ted spinner sits on your screen, hopefully keeping you entertained. But what if you
 get impatient? What if it seems like the download has failed but the spinner is still
 going? If your long-running task is using the event dispatch thread, your user won’t
 be able to click a Cancel button or take any action at all. Long-running tasks should
 be handled by separate threads that can run in the background, leaving your applica
tion responsive and available. But then how do we update the UI when that back
ground thread finishes? Swing has a helper for just that task.*/

/*SwingUtilities and Component Updates
 You can use the SwingUtilities class from any thread to perform updates to your UI
 components in a safe, stable manner. There are two static methods you can use to
 communicate with your UI:
 • invokeAndWait()
 • invokeLater()
 As their names imply, the first method runs some UI update code and makes the cur
rent thread wait for that code to finish before continuing. The second method hands
 off some UI update code to the event dispatch thread and then immediately resumes
 executing on the current thread. Which one you use really depends on whether your
 background thread needs to know the state of the UI before continuing. For example,
 if you are adding a new button to your interface, you might want to use invokeAnd
 Wait() so that by the time your background thread continues, it can be sure that
 future updates to the added button will actually have a button to update.
 If you aren’t as concerned about when something gets updated, just that it does even
tually get handled safely by the dispatch thread, invokeLater() is perfect. Think
 about updating a progress bar as a large file is downloading. You might fire off several
 updates with more and more of the download completed. You don’t need to wait for
 those graphical updates to finish before resuming your download. If a progress
 update gets delayed or runs very close to a second update, there’s no real harm. But
 you don’t want a busy graphical interface to interrupt your download—especially if
 the server is sensitive to pauses.
 We’ll see several examples of exactly this type of network/UI interaction in the next
 chapter, but let’s fake some network traffic and update a small label to show off Swing
 Utilities. We can set up a Start button that will update a status label with a simple
 percentage display and kick off a background thread that simply sleeps for a second,
 then increments the progress. Each time the thread wakes up, it will update the label
 using invokeLater() to correctly set the label’s text. First, let’s look at setting up our
 demo: */






import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class ProgressDemo {

    public static void main(String[] args) {
        JFrame frame = new JFrame("SwingUtilities 'invoke' Demo");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(300, 180);

        JLabel label = new JLabel("Download Progress Goes Here!", JLabel.CENTER);
        

        Thread pretender = new Thread(new ProgressPretender(label));
        JButton simpleButton = new JButton("Start");
        simpleButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                simpleButton.setEnabled(false);
                pretender.start();
            }
        });
        JLabel checkLabel = new JLabel("Can you still type?");
        JTextField checkField = new JTextField(10);
        frame.add(label);
        frame.add(simpleButton);
        frame.add(checkLabel);
        frame.add(checkField);
        frame.setVisible( true );
 }
    
}
/* Hopefully, most of this looks familiar, but we do want to point out a few interesting
 details. First, look at how we create our thread. We pass a new ProgressPretender
 call as the the argument to our Thread constructor. We could have broken that into
 separate parts, but since we do not refer to our ProgressPretender object again, we
 can stick with this tidier, denser approach. We do refer to the thread itself, however,
 so we make a proper variable for it. We can then start our thread running in the

 ActionListener for our button. Notice in this listener that we disable our Start but
ton. We don’t want the user trying to start a thread that is already running!
 The other thing we want to point out is that we added a text field for you to type in.
 While the progress is being updated, your application should continue responding to
 user input like typing. Try it! The text field isn’t connected to anything, of course, but
 you should be able to enter and delete text all while watching the progress counter
 slowly climb up
  */

  /*In this class, we store the label passed to our constructor so we know where to display
 our updated progress. The run() method has three basic steps: 1) update the label, 2)
 sleep for 1000 milliseconds, and 3) increment our progress.
 For step 1, notice the fairly complex argument we pass to invokeLater(). It looks a
 lot like a class definition, but it is based on the Runnable interface we saw in Chap
ter 9. This is another example of using anonymous inner classes in Java. There are
 other ways to create the Runnable object, but like handling simple events with anony
mous listeners, this thread pattern is very common. This nested Runnable argument
 updates the label with our current progress value—but again, it performs this update
 on the event dispatch thread. This is the magic that leaves the text field responsive
 even though our “progress” thread is sleeping most of the time.
 Step 2 is standard-issue thread sleeping. Recall that the sleep() method knows it can
 be interrupted, so the compiler will make sure you supply a try/catch block like
 we’ve done above. There are many ways we could handle the interruption, but in this
 case we chose to simply break out of the loop.
 Finally, we increment our progress counter and start the whole process over. Once we
 hit 100, the loop ends and our progress label should stop changing. If you wait
 patiently, you’ll see that final value. The app itself should remain active, though. You
 can still type in the text field. Our download is complete and all is well with the
 world! */