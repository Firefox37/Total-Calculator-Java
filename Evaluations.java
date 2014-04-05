
import java.io.*;
import java.lang.*;
import java.lang.Math;
public class Evaluations 
{
    int top=-1;
    int topd=-1;
    int size=0;
    public char arr[];
    double eval[];
    
    public Evaluations()
    {
    }

    public Evaluations(int d)
    { 
        size=d; 
        arr=new char[size];
        eval=new double[size];
    }

    public void push(char item)
    {
        if(top==size-1)
        {
            Calculator.t2.setText("Out of Memory !!!");
            Calculator.cond=2;
        }
        else
        {
            Calculator.cond=1;
            arr[++top]=item;
        }
    }

    public void push(double item)
    {
        if(topd==size-1)
        {
            Calculator.t2.setText("Out of Memory !!!");
            Calculator.cond=2;
        }
        else
        {
            Calculator.cond=1;
            eval[++topd]=item;
        }
    }

    public char pop()
    {
        char c;
        if(top==-1)
        {
            Calculator.t2.setText("Error");
            Calculator.cond=2;
            return 0;
        }
        else

        {
            Calculator.cond=1;
            c=arr[top];
            arr[top--]=' ';
            return c;
        }
    }

    public double pop(double h)
    {
        if(topd==-1)
        {
            Calculator.t2.setText("Error");
            Calculator.cond=2;
            return 0;
        }
        else
        {
            Calculator.cond=1;
            return eval[topd--];
        }
    }

    public void show()
    {
        for(int i=0;i<=top;i++)
            System.out.print(arr[i]);
    }

    public Evaluations replaceAll(String a,String b){
        String s=new String(arr);
        Evaluations p=new Evaluations(180);
        s=s.replaceAll(a,b);
        for(int i=0;i<s.length();i++){
            p.push(s.charAt(i));
        }
        return p;
    }

    public int preced(char a)
    {
        switch(a)
        {
            case '+':
            case '-':
            return 2;
            case '*':
            case '/':
            return 3;
            case '^':
            case 'n':
            case 'o':
            case 's':
            case 'c':
            return 4;
            case '#':
            case '$':
            case '@':
            case '&':
            case '`':
            case ':':
            case ';':
            case '~':
            case '%':	
            case 'q':
            case 'w':
            case 'z':
            return 5;
            case '!':
            return 6;
            default:
            return 1;
        }
    }

    public Evaluations infipost(Evaluations post)
    {
        Evaluations stck=new Evaluations(150);
        int i=0,j=0;
        char t;
        for(i=0;i<=top;i++)
        {  	  	
            t=arr[i];
            switch(t)
            {
                case '(':
                stck.push(t);
                break;
                case '+':
                case '-':
                case '*':
                case '/':
                case '^':
                case '#':
                case '~':
                case '&':
                case '@':
                case '!':
                case '`':
                case ':':
                case ';':
                case '%':
                case 'n':
                case 'o':
                case 'c':
                case 's':
                case 'q':
                case 'w':
                case 'z':
                if(post.top>=0)
                {
                    if(post.arr[post.top]!=',')
                        post.push(',');
                }
                if(stck.top>=0)
                {
                    if(preced(stck.arr[stck.top])>=preced(t))
                    {
                        while((stck.top>=0)&&(preced(stck.arr[stck.top])>=preced(t)))
                        {
                            post.push(stck.pop());
                            post.push(',');
                        }
                        stck.push(t);
                        break;
                    }

                    else
                        stck.push(t);
                    break;
                }
                else 
                    stck.push(t);
                break;
                case ')':
                while((stck.top>=0)&&(stck.arr[stck.top]!='('))
                {
                    if(post.arr[post.top]!=',')
                    {
                        post.push(',');
                    }
                    post.push(stck.pop());
                }
                stck.pop();
                break;
                default:
                post.push(t);
                break;
            }
        }
        while(stck.top>=0)
        { 
            if(post.arr[post.top]!=',')
                post.push(',');
            post.push(stck.pop());
            post.push(',');
        }
        post.pop();
        return post;
    }

    public double posteval()
    {
        Evaluations str=new Evaluations(150);
        double x,y,h=0;
        int j=0;
        for(int i=0;i<=top;i++)
        {
            switch(arr[i])
            {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case '.':
                str.push(arr[i]);
                break;
                case ',':
                if(str.top>=0)
                {
                    String s=new String(str.arr);
                    Double d=new Double(s);
                    this.push(d.doubleValue());
                    while(str.top>=0)
                        str.pop();
                }
                while(str.top>=0)
                    str.pop();
                break;
                case '+':
                x=pop(h);
                y=pop(h);
                System.out.print(x+" "+y+" "+(x+y));
                push(x+y);
                break;
                case '-':
                x=pop(h);
                y=pop(h);
                push(y-x);
                break;
                case '*':
                x=pop(h);
                y=pop(h);
                push(x*y);
                break;
                case '/':
                x=pop(h);
                y=pop(h);
                push(y/x);
                break;
                case '#':
                x=pop(h);
                if(Calculator.deg==2){
                    push(Math.sin(Math.toRadians(x)));
                }
                else
                    push(Math.sin(x));	
                break;
                case '~':
                x=pop(h);
                if(Calculator.deg==2){
                    push(Math.cos(Math.toRadians(x)));
                }
                else
                    push(Math.cos(x));
                break;
                case '@':
                x=pop(h);
                if(Calculator.deg==2){
                    push(Math.tan(Math.toRadians(x)));
                }
                else
                    push(Math.tan(x));
                break;
                case '&':
                x=pop(h);
                push(Math.log10(x));
                break;
                case '%':
                x=pop(h);
                if(Calculator.deg==2){
                    push(Math.toDegrees(Math.asin(x)));
                }
                else
                    push(Math.asin(x));
                break;
                case ';':
                x=pop(h);
                if(Calculator.deg==2){
                    push(Math.toDegrees(Math.acos(x)));
                }
                else
                    push(Math.acos(x));
                break;
                case ':':
                x=pop(h);
                if(Calculator.deg==2){
                    push(Math.toDegrees(Math.atan(x)));
                }
                else
                    push(Math.atan(x));
                break;
                case '`':
                x=pop(h);
                double b=Math.log(x);
                push(b);
                break;
                case '^':
                x=pop(h);
                y=pop(h);
                push(Math.pow(y,x));
                break;
                case '!':
                x=pop(h);
                int r=(int)x;
                if(x<0)
                {
                    push(0.0);
                    break;
                }
                else if(x==0)
                {
                    push(0.0);
                    break;
                }
                else
                {
                    for(int s=(int)r-1;s>1;s--)
                        r=r*s;
                    push(r);
                }
                break;
                case 'n':
                x=pop(h);
                push(Math.sqrt(x));
                break;
                case 'o':
                x=pop(h);
                push(Math.cbrt(x));
                break;
                case 's':
                x=pop(h);
                push(Math.pow(x,2));
                break;
                case 'c':
                x=pop(h);
                push(Math.pow(x,3));
                break;
                case 'q':
                x=pop(h);
                push(Math.sinh(x));
                break;
                case 'w':
                x=pop(h);
                push(Math.cosh(x));
                break;
                case 'z':
                x=pop(h);
                push(Math.tanh(x));
                break;
            }
        }
        return eval[0];
    }

    public static void main(String args[]) throws IOException
    {
        System.out.print('\u000C');
        Evaluations infix=new Evaluations(100);
        String str=new String(), str1,str2;
        Evaluations post=new Evaluations(100);
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter infix expression:");
        str=br.readLine();
        for(int i=0;i<str.length();i++)
        {
            infix.push(str.charAt(i));
        }
        post=infix.infipost(post);
        System.out.println("postfix expression::");
        post.show();
        double d=post.posteval();
        System.out.println("Result is: "+d);
    }
};