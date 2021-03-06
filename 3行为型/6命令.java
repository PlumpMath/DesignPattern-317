/*命令模式
*
* 将请求封装成对象，作为命令调用者和接收者的中介；
*/

//接收者角色类，提供各种操作的解决方案的类
public class Receiver 
{
    //真正执行命令相应的操作
    public void action()
	{
        System.out.println("执行操作");
    }
}

//抽象命令角色类
public interface Command 
{
    //执行方法
    void execute();
}

//具体命令角色类
public class ConcreteCommand implements Command 
{
    //持有相应的接收者对象
    private Receiver receiver = null;

    public ConcreteCommand(Receiver receiver)
	{
        this.receiver = receiver;
    }

    @Override
    public void execute() 
	{
        //通常会转调接收者对象的相应方法，让接收者来真正执行功能
        receiver.action();
    }
}

//请求者角色类
public class Invoker 
{
    //持有命令对象
    private Command command = null;
  
    public Invoker(Command command)
	{
        this.command = command;
    }

    public void action()
	{  
        command.execute();
    }
}

/*————————————————————————————————————————————*/

public class Client 
{
    public static void main(String[] args) 
	{
        //创建接收者
        Receiver receiver = new Receiver();

        //创建命令对象，设定它的接收者
        Command command = new ConcreteCommand(receiver);

        //创建请求者，把命令对象设置进去
        Invoker invoker = new Invoker(command);

        //执行方法
        invoker.action();
    }

}