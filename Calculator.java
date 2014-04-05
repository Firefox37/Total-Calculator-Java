import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener, ItemListener
{
    public String ans=new String();
    public static int deg=1;
    public static int cond=1;
    int x=0,y=0;
    
    CheckboxGroup cg=new CheckboxGroup();
    Checkbox c1=new Checkbox("Radians", cg, true);
    Checkbox c2=new Checkbox("Degrees", cg, false);
    
    JButton b0=new JButton("0");        JButton b1=new JButton("1");
    JButton b2=new JButton("2");        JButton b3=new JButton("3");
    JButton b4=new JButton("4");        JButton b5=new JButton("5");
    JButton b6=new JButton("6");        JButton b7=new JButton("7");
    JButton b8=new JButton("8");        JButton b9=new JButton("9");
    JButton b10=new JButton("=");       JButton b11=new JButton("+");
    JButton b12=new JButton("-");       JButton b13=new JButton("*");
    JButton b14=new JButton("/");       JButton b15=new JButton(".");
    JButton b16=new JButton("+/-");     JButton b17=new JButton("^");
    JButton b18=new JButton("(");       JButton b19=new JButton(")");
    JButton b20=new JButton("sin");     JButton b21=new JButton("cos");
    JButton b22=new JButton("tan");     JButton b23=new JButton("arcsin");
    JButton b24=new JButton("arccos");  JButton b25=new JButton("arctan");
    JButton b26=new JButton("ln");      JButton b27=new JButton("log");
    JButton b28=new JButton("n!");      JButton b29=new JButton("\u221A");
    JButton b30=new JButton("3"+"\u221A");      
    JButton b31=new JButton("x²");
    JButton b32=new JButton("x³");      JButton b33=new JButton("e^n");
    JButton b34=new JButton("10^n");    JButton b35=new JButton("sinh");   
    JButton b36=new JButton("cosh");    JButton b37=new JButton("tanh");
    
    JButton AC=new JButton("AC");       JButton DEL=new JButton("DEL");
    JButton ANS=new JButton("ANS");     JButton M=new JButton("M");
    JButton CM=new JButton("CM");       JButton RM=new JButton("RM");
    JButton G=new JButton("Graph");     JButton X=new JButton("X");
    JButton be=new JButton("e");        JButton bpi=new JButton("pi");

    public static JTextArea t1=new JTextArea("",1,400);
    public static JTextArea t2=new JTextArea("",1,400);

    Calculator()
    {
        super("Scientific Calculator");
        int w=90,h=50,l=7*w-5,b=70,x=w*7,y=10*h;
        setSize(x+5,y+2*h-10);
        setLayout(null);

        b0.addActionListener(this);     b1.addActionListener(this);
        b2.addActionListener(this);     b3.addActionListener(this);
        b4.addActionListener(this);     b5.addActionListener(this);
        b6.addActionListener(this);     b7.addActionListener(this);
        b8.addActionListener(this);     b9.addActionListener(this);
        b10.addActionListener(this);    b11.addActionListener(this);
        b12.addActionListener(this);    b13.addActionListener(this);
        b14.addActionListener(this);    b15.addActionListener(this);
        b16.addActionListener(this);    b17.addActionListener(this);
        b18.addActionListener(this);    b19.addActionListener(this);
        b20.addActionListener(this);    b21.addActionListener(this);
        b22.addActionListener(this);    b23.addActionListener(this);
        b24.addActionListener(this);    b25.addActionListener(this);
        b26.addActionListener(this);    b27.addActionListener(this);
        b28.addActionListener(this);    b29.addActionListener(this);
        b30.addActionListener(this);    b31.addActionListener(this);
        b32.addActionListener(this);    be.addActionListener(this);
        bpi.addActionListener(this);    b37.addActionListener(this);
        AC.addActionListener(this);     DEL.addActionListener(this);
        ANS.addActionListener(this);    CM.addActionListener(this);
        G.addActionListener(this);      b34.addActionListener(this);
        X.addActionListener(this);      RM.addActionListener(this);
        M.addActionListener(this);      b33.addActionListener(this);
        b35.addActionListener(this);    b36.addActionListener(this);    

        c1.addItemListener(this);   
        c2.addItemListener(this);

        add(b0);    add(t1);    add(t2);    add(b1);
        add(b2);    add(b3);    add(b4);    add(b5);
        add(b6);    add(b7);    add(b8);    add(b9);
        add(b10);   add(b11);   add(b12);   add(b13);
        add(b14);   add(b15);   add(b16);   add(b17);
        add(b18);   add(b19);   add(b20);   add(b21);
        add(b22);   add(b23);   add(b24);   add(b25);
        add(b26);   add(b27);   add(AC);    add(b28);
        add(b29);   add(b30);   add(b31);   add(b32);
        add(ANS);   add(DEL);   add(CM);    add(RM);
        add(G);     add(X);     add(M);     add(b33);
        add(b34);   add(be);    add(bpi);   add(b37);
        add(b35);   add(b36);   add(c1);    add(c2);

        JScrollPane j1=new JScrollPane(t1,ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        JScrollPane j2=new JScrollPane(t2,ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        Container c=getContentPane();
        c.add(j1);
        c.add(j2);

        t1.setFont(new Font("Times New Roman",0,30));       t2.setFont(new Font("Times New Roman",0,30));
        b0.setFont(new Font("Times New Roman",0,20));       b1.setFont(new Font("Times New Roman",0,20));
        b2.setFont(new Font("Times New Roman",0,20));       b3.setFont(new Font("Times New Roman",0,20));
        b4.setFont(new Font("Times New Roman",0,20));       b5.setFont(new Font("Times New Roman",0,20));
        b6.setFont(new Font("Times New Roman",0,20));       b7.setFont(new Font("Times New Roman",0,20));
        b8.setFont(new Font("Times New Roman",0,20));       b9.setFont(new Font("Times New Roman",0,20));
        b10.setFont(new Font("Times New Roman",0,20));      b11.setFont(new Font("Times New Roman",0,20));
        b12.setFont(new Font("Times New Roman",0,20));      b13.setFont(new Font("Times New Roman",0,20));
        b14.setFont(new Font("Times New Roman",0,20));      b15.setFont(new Font("Times New Roman",1,20));
        b16.setFont(new Font("Times New Roman",0,20));      b17.setFont(new Font("Times New Roman",0,20));
        b18.setFont(new Font("Times New Roman",0,20));      b19.setFont(new Font("Times New Roman",0,20));
        b20.setFont(new Font("Times New Roman",0,20));      b21.setFont(new Font("Times New Roman",0,20));
        b22.setFont(new Font("Times New Roman",0,20));      b23.setFont(new Font("Times New Roman",0,20));
        b24.setFont(new Font("Times New Roman",0,20));      b25.setFont(new Font("Times New Roman",0,20));
        b26.setFont(new Font("Times New Roman",0,20));      b27.setFont(new Font("Times New Roman",0,20));
        b28.setFont(new Font("Times New Roman",0,20));      ANS.setFont(new Font("Times New Roman",1,20));
        M.setFont(new Font("Times New Roman",1,20));        CM.setFont(new Font("Times New Roman",1,20));
        RM.setFont(new Font("Times New Roman",1,20));       DEL.setFont(new Font("Times New Roman",1,20));
        AC.setFont(new Font("Times New Roman",1,20));       G.setFont(new Font("Times New Roman",0,20));
        X.setFont(new Font("Times New Roman",0,20));        c1.setFont(new Font("Times New Roman",1,18));
        c2.setFont(new Font("Times New Roman",1,18));       
        b34.setFont(new Font("Times New Roman",0,20));
        b33.setFont(new Font("Times New Roman",0,20));      b29.setFont(new Font("Times New Roman",0,20));
        b30.setFont(new Font("Times New Roman",0,20));      b31.setFont(new Font("Times New Roman",0,20));
        b32.setFont(new Font("Times New Roman",0,20));      
        b30.setFont(new Font("Times New Roman",0,20));      b37.setFont(new Font("Times New Roman",0,20));
        b35.setFont(new Font("Times New Roman",0,20));      b36.setFont(new Font("Times New Roman",0,20));
        be.setFont(new Font("Times New Roman",0,20));       bpi.setFont(new Font("Times New Roman",0,20));

        t2.setEditable(false);

        b0.setBounds(0,y,w,h);      b15.setBounds(w,y,w,h);     b10.setBounds(2*w,y,w,h);       b11.setBounds(3*w,y,w,h);
        bpi.setBounds(4*w,y,w,h);   b29.setBounds(5*w,y,w,h);   M.setBounds(6*w,y,w,h);
        y=y-h;
        b1.setBounds(0,y,w,h);      b2.setBounds(w,y,w,h);      b3.setBounds(2*w,y,w,h);        b12.setBounds(3*w,y,w,h);
        be.setBounds(4*w,y,w,h);    b30.setBounds(5*w,y,w,h);   RM.setBounds(6*w,y,w,h);
        y=y-h;
        b4.setBounds(0,y,w,h);      b5.setBounds(w,y,w,h);      b6.setBounds(2*w,y,w,h);        b13.setBounds(3*w,y,w,h);
        b17.setBounds(4*w,y,w,h);   b31.setBounds(5*w,y,w,h);   CM.setBounds(6*w,y,w,h);
        y=y-h;
        b7.setBounds(0,y,w,h);      b8.setBounds(w,y,w,h);      b9.setBounds(2*w,y,w,h);        b14.setBounds(3*w,y,w,h);
        b28.setBounds(4*w,y,w,h);   b32.setBounds(5*w,y,w,h);   ANS.setBounds(6*w,y,w,h);
        y=y-h;
        b33.setBounds(0,y,w,h);     b34.setBounds(w,y,w,h);     b26.setBounds(2*w,y,w,h);       b27.setBounds(3*w,y,w,h);
        b18.setBounds(4*w,y,w,h);   b19.setBounds(5*w,y,w,h);   DEL.setBounds(6*w,y,w,h);
        y=y-h;
        b20.setBounds(0,y,w,h);     b21.setBounds(w,y,w,h);     b22.setBounds(2*w,y,w,h);       b23.setBounds(3*w,y,w,h);
        b24.setBounds(4*w,y,w,h);   b25.setBounds(5*w,y,w,h);   AC.setBounds(6*w,y,w,h);
        y=y-h;
        b35.setBounds(0,y,w,h);     b36.setBounds(w,y,w,h);     b37.setBounds(2*w,y,w,h); 
        c1.setBounds(315,y,100,h-10);                           c2.setBounds(495,y,100,h-10);
        y=y-h;
        j1.setBounds(2,10,l,b);     j2.setBounds(2,110,l,b);

        t1.setBackground(Color.WHITE);  t2.setBackground(Color.WHITE);  
        c1.setForeground(Color.black);  c2.setForeground(Color.black);  c.setBackground(Color.white);

        setVisible(true);
        validate();
    }
    public void actionPerformed (ActionEvent a)
    {
        if(a.getSource()==b0)
            t1.append("0");
        if(a.getSource()==b1)
            t1.append("1");
        if(a.getSource()==b2)
            t1.append("2");
        if(a.getSource()==b3)
            t1.append("3");
        if(a.getSource()==b4)
            t1.append("4");
        if(a.getSource()==b5)
            t1.append("5");
        if(a.getSource()==b6)
            t1.append("6");
        if(a.getSource()==b7)
            t1.append("7");
        if(a.getSource()==b8)
            t1.append("8");
        if(a.getSource()==b9)
            t1.append("9");
        if(a.getSource()==b11)
            t1.append("+");
        if(a.getSource()==b12)
            t1.append("-");
        if(a.getSource()==b13)
            t1.append("*");
        if(a.getSource()==b14)
            t1.append("/");
        if(a.getSource()==b15)
            t1.append(".");
        if(a.getSource()==b16)
            t1.append("");
        if(a.getSource()==b17)
            t1.append("^");
        if(a.getSource()==b18)
            t1.append("(");
        if(a.getSource()==b19)
            t1.append(")");
        if(a.getSource()==b20)
            t1.append("sin");
        if(a.getSource()==b21)
            t1.append("cos");
        if(a.getSource()==b22)
            t1.append("tan");
        if(a.getSource()==b23)
            t1.append("arcsin");
        if(a.getSource()==b24)
            t1.append("arccos");
        if(a.getSource()==b25)
            t1.append("arctan");
        if(a.getSource()==b26)
            t1.append("ln");
        if(a.getSource()==b27)
            t1.append("log");
        if(a.getSource()==b28)
            t1.append("!");
        if(a.getSource()==b29)
            t1.append("\u221A");
        if(a.getSource()==b30)
            t1.append("3"+"\u221A");
        if(a.getSource()==b31)
            t1.append("²");
        if(a.getSource()==b32)
            t1.append("³");
        if(a.getSource()==b34)
            t1.append("10^");
        if(a.getSource()==b33)
            t1.append("e^");
        if(a.getSource()==b35)
            t1.append("sinh");  
        if(a.getSource()==b36)
            t1.append("cosh");  
        if(a.getSource()==b37)
            t1.append("tanh");  
        if(a.getSource()==X)
            t1.append("x");
        if(a.getSource()==be)
            t1.append("e");
        if(a.getSource()==bpi)
            t1.append("pi");
        if(a.getSource()==M)
            ans=t2.getText();
        if(a.getSource()==CM)
            ans="";
        if(a.getSource()==RM)
            t1.append(ans);
        if(a.getSource()==ANS)
        {
            try{
                Evaluations infix=new Evaluations(200);
                Evaluations post=new Evaluations(200);
                String str=new String();

                str=t1.getText();

                str=str.replaceAll("arcsin","%");
                str=str.replaceAll("arccos",";");
                str=str.replaceAll("arctan",":");
                str=str.replaceAll("sinh","q");
                str=str.replaceAll("cosh","w");
                str=str.replaceAll("tanh","z");
                str=str.replaceAll("sin","#");
                str=str.replaceAll("cos","~");
                str=str.replaceAll("tan","@");
                str=str.replaceAll("log","&");

                str=str.replaceAll("ln","`");
                str=str.replaceAll("\u221A","n");
                str=str.replaceAll("3"+"\u221A","o");
                str=str.replaceAll("²","s");
                str=str.replaceAll("³","c");
                str=str.replaceAll("e","2.718281828459045");
                str=str.replaceAll("pi","3.141592653589793");

                for(int i=0;i<str.length();i++)
                    infix.push(str.charAt(i));
                post=infix.infipost(post);
                double d=post.posteval();
                t1.setText(d+"");
            }
            catch(Exception e)
            {
                t2.setText("Error");
            }
        }
        if(a.getSource()==b10)
        {
            Evaluations infix=new Evaluations(200);
            Evaluations post=new Evaluations(200);
            String str=new String();
            try
            {
                str=t1.getText();
                str=str.replaceAll("arcsin","%");
                str=str.replaceAll("arccos",";");
                str=str.replaceAll("arctan",":");
                str=str.replaceAll("sinh","q");
                str=str.replaceAll("cosh","w");
                str=str.replaceAll("tanh","z");
                str=str.replaceAll("sin","#");
                str=str.replaceAll("cos","~");
                str=str.replaceAll("tan","@");
                str=str.replaceAll("log","&");
                str=str.replaceAll("ln","`");
                str=str.replaceAll("\u221A","n");
                str=str.replaceAll("3"+"\u221A","o");
                str=str.replaceAll("²","s");
                str=str.replaceAll("³","c");
                str=str.replaceAll("e","2.718281828459045");
                str=str.replaceAll("pi","3.141592653589793");
                for(int i=0;i<str.length();i++)
                    infix.push(str.charAt(i));
                post=infix.infipost(post);
                if(cond==2)
                {
                    t2.setText("Error");
                    //System.out.println(cond);
                }
                else
                {
                    double d=post.posteval();
                    t2.setText(d+"");
                    //System.out.println(cond);
                }
            }
            catch(Exception e)
            {
                t2.setText("Error");
            }
        }
        if(a.getSource()==DEL)
        {
            String s=new String(t1.getText());
            char o[]=new char[(s.length())-1];
            for(int i=0;i<s.length()-1;i++)
                o[i]=s.charAt(i);
            String s1=new String(o);
            t1.setText(s1);
        }
        if(a.getSource()==AC)
        {
            t1.setText("");
            t2.setText("");
        }
    }
    public void itemStateChanged(ItemEvent ie)
    {
        if(ie.getSource()==c1)
            deg=1;
        if(ie.getSource()==c2)
            deg=2;
        validate();
    }
    public static void main(String args[])
    {
        new Calculator();
    }

}