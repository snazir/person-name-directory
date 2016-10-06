# person-name-directory


1. What is the major difference between an abstract class and an interface?

To achieve abstraction, We use Abstract Class and Interface by declaring abstract methods. Abstract class and interface both can't be instantiated. But there are following difference between them
   a. Abstract class can have both abstract and non-abstract methods . In other hands, Interface can have only abstract methods.
   b. To get Multiple Inheritence Features, Interfaces can be used but Abstract class does not suppport Multiple Inheritence.
   c. Abstract class can have static methods, main method and constructor. But Interfacesd don't.
   
   

2. Why is Java 7’s class inheritance flawed?

Not sure, if you are asking about the Multiple Inheritence in Java, That is not possible due to Diamond Problem.


3. What are the major differences between Activities and Fragments?

In Android , complete screen with which user interacts is called as activity.Activity has its own life cycle. But thr fragment is sub part of activity having its own life cycle. Fragament UI and implementation is independent but fragment always needs an underlying activity.



4. When using Fragments, how do you communicate back to their hosting Activity?
For User interface organization,Better re-usability and dividing the tasks of activity , we use independent fragments. And also to communicate different part of a single activity ,we use Interfaces.


5. Can you make an entire app without ever using Fragments? Why or why not?Are there any special cases when you absolutely have to use or should use Fragments?

It depends on complexity of the project Simple and Small Application can be created by using activities . But best approach is to design the screens with Fragments . As when we have a app user of Larger Device, the these are fragments that will help us to reuse the code to merge the 2 or 3 fragments to cover the screen well. That is not possible in architecture with Activity.Moreover, When the complex scnario is there and we need to pass the data frequently between different screens, there it will be hard to manage with activities.


6. What makes an AsyncTask such an annoyance to Android developers? Detail some of the issues with AsyncTask, and how to potentially solve them.

If for any reason , the Activity instance that started the AsyncTask destroyed, but will kept in memory until the AsyncTask finishes. Since Activities are heavy this could lead to memory issues if several AsyncTasks are started.For this , we have to cancel the asynctask , if the activity is stopping/destroying. Another issue is that the result of the AsyncTask could be lost, if it's depend on state of activity.One more issue , when one asynctask is running to do some task , and for some reason , agaiin that task started , Then we have to stop the previous one.

