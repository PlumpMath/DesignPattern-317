/*责任链模式
*
* 使得多个对象都有机会处理请求，从而避免请求的发送者和接收者之间的耦合关系 
*（对于一个URL，HTTP处理器处理不了，将责任传递给FTP处理器）；
*/

//抽象处理者角色
public abstract class Handler {
    
    //持有后继的责任对象
    protected Handler successor;

    //示意处理请求的方法，虽然这个示意方法是没有传入参数的
    //但实际是可以传入参数的，根据具体需要来选择是否传递参数
    public abstract void handleRequest();

    //取值方法
    public Handler getSuccessor() 
	{
        return successor;
    }

    //赋值方法，设置后继的责任对象
    public void setSuccessor(Handler successor) 
	{
        this.successor = successor;
    } 
}

//具体处理者
public class ConcreteHandler extends Handler {

    //处理方法，调用此方法处理请求
    @Override
    public void handleRequest() 
	{
        //判断是否有后继的责任对象：
        //如果有，就转发请求给后继的责任对象；如果没有，则处理请求
        if(getSuccessor() != null)
        {            
            System.out.println("传递请求");
            getSuccessor().handleRequest();            
        }else
        {            
            System.out.println("处理请求");
        }
    }

}

/*————————————————————————————————————————————*/

public class Client {

    public static void main(String[] args) 
	{
        //组装责任链
        Handler handler1 = new ConcreteHandler();
        Handler handler2 = new ConcreteHandler();
        handler1.setSuccessor(handler2);

        //提交请求
        handler1.handleRequest();
    }

}