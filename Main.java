import java.util.*;
import java.io.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
public class Main implements ActionListener
{
  JFrame jfrm;
  JPanel p;
  JLabel jl;
  JLabel jl1;
  JTextField jtf;
  JLabel jl2;
  JLabel jl3;
  JLabel jl4;
  JTextArea fd;
  JLabel outPutKeys;
  JLabel minimalis;
  JLabel formIndicator;
  JTextArea finalAnswer;
  JLabel prime;
  public  Main()
  {
    //makeGui();

      jfrm=new JFrame("Table Normalizer");
      jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //jfrm.setSize(500,1000);
      jfrm.setBounds(100, 300, 650, 688);
      jfrm.getContentPane().setBackground(new Color(255, 255, 204));
      jfrm.setLayout((new FlowLayout(FlowLayout.LEFT)));
       p = new JPanel();
      p.setLayout((new FlowLayout(FlowLayout.CENTER)));
      jl=new JLabel("TABLE NORMALIZER");
      //jl.setFont(new Font(jl. getName(), Font. ARIAL,40));
      jl.setFont(new Font("Serif", Font.BOLD, 40));
      Dimension size = jl.getPreferredSize();
      jl.setBounds(500,0, size.width, size.height);
      p.add(jl);
      jfrm.add(p);
      jl1=new JLabel("Enter the number of attributes present in your relation - ");
      Dimension size1=jl1.getPreferredSize();
      jl1.setFont(new Font(jl1. getName(), Font. PLAIN,15));
      jl1.setBounds(10,75, size1.width, size1.height);
      jfrm.getContentPane().add(jl1);
      jtf=new JTextField(2);
      jtf.setBounds(320,75, size1.width, size1.height);
      jfrm.getContentPane().add(jtf);
      jl2=new JLabel("Attributes of the relation is as follow: ");
      Dimension size2=jl2.getPreferredSize();
      jl2.setFont(new Font(jl2. getName(), Font. PLAIN,15));
      jl2.setBounds(10,110,size2.width,size2.height);
      jfrm.getContentPane().add(jl2);
      jl3=new JLabel("                                                                  ");
      Dimension size3=jl3.getPreferredSize();
      jl3.setBounds(220,110, size3.width, size3.height);
      jfrm.getContentPane().add(jl3);
      jl3.setFont(new Font(jl3. getName(), Font. PLAIN,15));
      jl4=new JLabel("Give the functional dependencies(seprated by comma):-                                                   ");
      Dimension size4=jl4.getPreferredSize();
      jl4.setFont(new Font("Serif", Font.BOLD, 20));
    //  jl4.setFont(new Font(jl4. getName(), Font. PLAIN,15));
      jl4.setBounds(10,110,size4.width,size4.height);
      jfrm.getContentPane().add(jl4);
      jtf.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae){
        String str= jtf.getText();
        fd.setText(null);
        outPutKeys.setText("                                                                                                          ");
        minimalis.setText("                                                                                                          ");
        formIndicator.setText("                                                                                                          ");
        finalAnswer.setText(null);
        prime.setText("                                                                                                                 ");
          try{

              jl3.setText(null);
              jl3.setBounds(900,110, size3.width, size3.height);
              jl3.setText("R:-{");
              for(int i=0;i<Integer.parseInt(str);i++)
              {
                String str1=jl3.getText();
                if(i!=Integer.parseInt(str)-1)
                {
                  jl3.setText(str1+(char)(i+97)+", ");
                }
                else
                {
                  jl3.setText(str1+(char)(i+97)+"}");
                }
              }
          }
          catch(Exception e)
          {
            createDialogBox(jfrm);
            jtf.setText(null);
          }
        }
      });
      fd=new JTextArea(2,100);
      fd.setFont(new Font(fd. getName(), Font. PLAIN,15));
      jfrm.add(fd);
      JButton primeattributes=new JButton("Prime Attributes");
      primeattributes.setActionCommand("prime");
      primeattributes.addActionListener(this);
      jfrm.add(primeattributes);
      prime=new JLabel("                                                                                                                  ");
      jfrm.add(prime);
      prime.setFont(new Font(prime. getName(), Font. PLAIN,20));

      JButton keys=new JButton("Find All candidate keys");
      keys.setActionCommand("keys");
      keys.addActionListener(this);
      jfrm.add(keys);
      outPutKeys=new JLabel("                                                                                                                ");
      jfrm.add(outPutKeys);
      outPutKeys.setFont(new Font(outPutKeys. getName(), Font. PLAIN,20));
      JButton minimal=new JButton("Find the minimal");
      minimal.setActionCommand("minimal");
      minimal.addActionListener(this);
      jfrm.add(minimal);
      minimalis=new JLabel("                                                                                                                      ");
      jfrm.add(minimalis);
      minimalis.setFont(new Font(minimalis. getName(), Font. PLAIN,20));
      JButton nfForm=new JButton("Calculate the present nf form");
      nfForm.setActionCommand("nfform");
      nfForm.addActionListener(this);
      jfrm.add(nfForm);
      formIndicator=new JLabel("                                                                                                                      ");
      jfrm.add(formIndicator);
      formIndicator.setFont(new Font(formIndicator. getName(), Font. PLAIN,20));
      JButton nextForm=new JButton("X+1 Nf Form");
      nextForm.setActionCommand("next");
      nextForm.addActionListener(this);
      jfrm.add(nextForm);

      JButton second=new JButton("2 Nf Form");
      second.setActionCommand("2");
      second.addActionListener(this);
      jfrm.add(second);

      JButton third=new JButton("3 Nf Form");
      third.setActionCommand("3");
      third.addActionListener(this);
      jfrm.add(third);

      JButton fourth=new JButton("BCNF Form");
      fourth.setActionCommand("4");
      fourth.addActionListener(this);
      jfrm.add(fourth);


      finalAnswer=new JTextArea(7,100);
      finalAnswer.setFont(new Font(finalAnswer.getName(),Font.PLAIN,15));
      jfrm.add(finalAnswer);

      jfrm.setVisible(true);
  }
  public int findN()
  {
    try{
          int n=Integer.parseInt(jtf.getText());
          return n;
    }
    catch(Exception e)
    {
    //  System.out.println("This is renold ");
      createDialogBox(jfrm);
      jtf.setText(null);
      fd.setText(null);
      jl3.setText(null);
      finalAnswer.setText(null);
    }
    return 0;
  }
  public int findM(int n)
  {
    String dependencies=fd.getText();
    try
    {
      for(int i=0;i<dependencies.length();i++)
      {
        if(dependencies.charAt(i)=='-'||dependencies.charAt(i)=='>'||dependencies.charAt(i)==','||(dependencies.charAt(i)>='a'&&dependencies.charAt(i)<=(char)(96+n)))
        {
          continue;
        }
        else
        {
          throw new NullPointerException("demo");
        }
      }
    }
    catch(Exception e)
    {
      //System.out.println("This is shakespar");
      createDialogBox(jfrm);
      jtf.setText(null);
      fd.setText(null);
      jl3.setText(null);
    }
    String [] arrOfStr=dependencies.split(",");
     int m=arrOfStr.length;
     return m;
  }
  public void findingFunctionalDependencies(char functionalDependencies[][],int m)
  {
    String dependencies=fd.getText();
    String [] arrOfStr=dependencies.split(",");
    String str=null;
    for(int i=0;i<m;i++)
    {
      str=arrOfStr[i];
      for(int j=0;j<str.length();j++)
      {
        functionalDependencies[i][j]=str.charAt(j);
      }
    }
  }
  public void actionPerformed(ActionEvent ae){
    if(ae.getActionCommand()=="prime")
    {
      int n=findN();
      int m=findM(n);;
      char [][] functionalDependencies=new char [m][100];
      CalculateMinimal cm=new CalculateMinimal();
      cm.clear(functionalDependencies,m,100);
      findingFunctionalDependencies(functionalDependencies,m);

      char [][] newKey=new char[100][100];
      cm.clear(newKey,100,100);
      CalculateNewKey cnk=new CalculateNewKey();
      int count=cnk.calculatenewKey(functionalDependencies,m,n,newKey);
      char [][] candidatekey=new char[100][100];
      cm.clear(candidatekey,100,100);
      /*for(int i=0;i<count;i++)
      {
        System.out.println(newKey[i]);
      }*/
      int count1=0;
      for(int i=0;i<count;i++)
      {
        if(newKey[i][0]!='\0')
        {
          for(int j=0;newKey[i][j]!='\0';j++)
          {
            candidatekey[count1][j]=newKey[i][j];
          }
          count1++;
        }
      }
      int [] vis=new int [n];
      for(int i=0;i<count1;i++)
      {
        for(int j=0;candidatekey[i][j]!='\0';j++)
        {
          vis[candidatekey[i][j]-'a']=1;
        }
      }
      int sum=0;
      for(int i=0;i<n;i++)
      {
        sum=sum+vis[i];
      }
      char[] p=new char[2*sum];
      int flex=0;
    int  pointer54=0;
      for(int i=0;i<n;i++)
      {
        if(vis[i]==1)
        {
          flex++;
          p[pointer54++]=(char)(i+97);
          if(flex!=sum)
          p[pointer54++]=',';
        }
      }
      String str54=new String(p);
      prime.setText("The prime attributes are "+str54+"                                                                    ");
    }
    if(ae.getActionCommand()=="keys")
    {
      int n=findN();
      int m=findM(n);;
      char [][] functionalDependencies=new char [m][100];
      CalculateMinimal cm=new CalculateMinimal();
      cm.clear(functionalDependencies,m,100);
      findingFunctionalDependencies(functionalDependencies,m);

      char [][] newKey=new char[100][100];
      cm.clear(newKey,100,100);
      CalculateNewKey cnk=new CalculateNewKey();
      int count=cnk.calculatenewKey(functionalDependencies,m,n,newKey);
      char [][] candidatekey=new char[100][100];
      cm.clear(candidatekey,100,100);
      /*for(int i=0;i<count;i++)
      {
        System.out.println(newKey[i]);
      }*/
      int count1=0;
      for(int i=0;i<count;i++)
      {
        if(newKey[i][0]!='\0')
        {
          for(int j=0;newKey[i][j]!='\0';j++)
          {
            candidatekey[count1][j]=newKey[i][j];
          }
          count1++;
        }
      }
      String str1=findString(candidatekey,count1);
      outPutKeys.setText("The candidate keys are as following:- "+str1+"                            ");
    }
    if(ae.getActionCommand()=="minimal")
    {
      int n=findN();
      int m=findM(n);
      char [][] functionalDependencies=new char [m][100];
      CalculateMinimal cm1=new CalculateMinimal();
      cm1.clear(functionalDependencies,m,100);
      findingFunctionalDependencies(functionalDependencies,m);

      CalculateMinimal cm=new CalculateMinimal();
      char [][] minimal=new char [100][100];
      cm1.clear(minimal,100,100);
      int count=cm.calculateMinimal(functionalDependencies,m,n,minimal);
      String str1=findString(minimal,count);
      minimalis.setText("The minimal is following:- "+str1+"                                     ");
    }
    if(ae.getActionCommand()=="nfform")
    {
      int n=findN();
      int m=findM(n);
      char [][] functionalDependencies=new char [m][100];
      CalculateMinimal cm2=new CalculateMinimal();
      cm2.clear(functionalDependencies,m,100);
      findingFunctionalDependencies(functionalDependencies,m);
      char [][] newKey=new char[100][100];
      cm2.clear(newKey,100,100);
      CalculateNewKey cnk=new CalculateNewKey();
      int count=cnk.calculatenewKey(functionalDependencies,m,n,newKey);
      char [][] candidatekey=new char[100][100];
      cm2.clear(candidatekey,100,100);

      int count1=0;
      for(int i=0;i<count;i++)
      {
        if(newKey[i][0]!='\0')
        {
          for(int j=0;newKey[i][j]!='\0';j++)
          {
            candidatekey[count1][j]=newKey[i][j];
          }
          count1++;
        }
      }
    //  CalculateMinimal cm=new CalculateMinimal();
      char [][] minimal=new char [100][100];
      int count2=cm2.calculateMinimal(functionalDependencies,m,n,minimal);
      int [] nfform=new int[count2];
      char [][] newTables=new char[100][100];
      //cm.clear(newTables,100,100);
      FindForm ff=new FindForm();
      ff.findForm(candidatekey,count1,minimal,count2,n,nfform);
      CalculateForm cf=new CalculateForm();
      int form=cf.calculateForm(nfform,count2);
      if(form!=4)
      formIndicator.setText("The Nf Form of the above function dependencies is :- "+form+"               ");
      if(form==4)
      formIndicator.setText("The Nf Form of the above functional dependencies is :- BCNF             ");
    }
    if(ae.getActionCommand()=="next")
    {
      int n=findN();
      int m=findM(n);
      char [][] functionalDependencies=new char [m][100];
      CalculateMinimal cm3=new CalculateMinimal();
      cm3.clear(functionalDependencies,m,100);
      findingFunctionalDependencies(functionalDependencies,m);
      char [][] newKey=new char[100][100];
      cm3.clear(newKey,100,100);
      CalculateNewKey cnk=new CalculateNewKey();
      int count=cnk.calculatenewKey(functionalDependencies,m,n,newKey);
      char [][] candidatekey=new char[100][100];
      cm3.clear(candidatekey,100,100);

      int count1=0;
      for(int i=0;i<count;i++)
      {
        if(newKey[i][0]!='\0')
        {
          for(int j=0;newKey[i][j]!='\0';j++)
          {
            candidatekey[count1][j]=newKey[i][j];
          }
          count1++;
        }
      }
    //  CalculateMinimal cm=new CalculateMinimal();
      char [][] minimal=new char [100][100];
      int count2=cm3.calculateMinimal(functionalDependencies,m,n,minimal);
      int [] nfform=new int[count2];
      char [][] newTables=new char[100][100];
      //cm.clear(newTables,100,100);
      FindForm ff=new FindForm();
      ff.findForm(candidatekey,count1,minimal,count2,n,nfform);
      CalculateForm cf=new CalculateForm();
      int form=cf.calculateForm(nfform,count2);
      char [][] newTables1=new char[100][100];
      cm3.clear(newTables1,100,100);
      if(form==1)
      {
        NextForm nf=new NextForm();
        int noOfNewTables=nf.tonf2(minimal,count2,nfform,m,n,newTables1);
        String str100=findString(candidatekey,count1);
        printnf2(minimal,newTables1,noOfNewTables,n,str100,candidatekey,count1);
      }
      if(form==2)
      {
        NextForm nf=new NextForm();
        CalculateMinimal cm10=new CalculateMinimal();
        char [][] newDependencies=new char[100][100];
        cm10.clear(newDependencies,100,100);
        count2=nf.combineMinimal(minimal,count2);
        int[] nfform1=new int [count2];
        ff.findForm(candidatekey,count1,minimal,count2,n,nfform1);
        nf.findOnlyKeyAttributes(candidatekey,count1,minimal,count2,newDependencies,n,nfform1);
        String str100=findString(candidatekey,count1);
        printnf3(minimal,newDependencies,n,str100,candidatekey,count1);
      }
      if(form==3)
      {
        CalculateMinimal cm=new CalculateMinimal();
        NextForm nf=new NextForm();
        count2=nf.combineMinimal(minimal,count2);
        int[] nfform1=new int [count2];
        ff.findForm(candidatekey,count1,minimal,count2,n,nfform1);
        char [][]temp=new char[count2][100];
        cm.clear(temp,count2,100);
        int counter=findBCNF(minimal,count2,nfform1,n,temp);
        count2=0;
        for(int i=0;minimal[i][0]!='\0';i++)
        {
          count2++;
        }
        /*System.out.println("The existing tables are");

        for(int i=0;i<count2;i++)
        {
          System.out.println(minimal[i]);
        }

        System.out.println("The new tables are");

        for(int i=0;i<counter;i++)
        {
          System.out.println(temp[i]);
        }*/
        char[][] candidatekey1=new char [100][100];
        char[][] candidatekey2=new char [100][100];
        cm.clear(candidatekey1,100,100);
        cm.clear(candidatekey2,100,100);
        for(int i=0;i<count1;i++)
        {
          for(int j=0;candidatekey[i][j]!='\0';j++)
          {
            candidatekey1[i][j]=candidatekey[i][j];
          }
        }
        int noOfKeys=candidatekey(candidatekey1,count1,minimal,count2,n,candidatekey2);
        String str54=findString(candidatekey2,count1-noOfKeys);
        printnf4(candidatekey1,noOfKeys,minimal,temp,counter,n,str54);
      }
      if(form==4)
      {
        NextForm nf=new NextForm();
        finalAnswer.setText("The given functionalDependencies are in BCNF hence there is no need to decompose the tables");
      }
    }
    if(ae.getActionCommand()=="2")
    {
      int n=findN();
      int m=findM(n);
      char [][] functionalDependencies=new char [m][100];
      CalculateMinimal cm3=new CalculateMinimal();
      cm3.clear(functionalDependencies,m,100);
      findingFunctionalDependencies(functionalDependencies,m);
      char [][] newKey=new char[100][100];
      cm3.clear(newKey,100,100);
      CalculateNewKey cnk=new CalculateNewKey();
      int count=cnk.calculatenewKey(functionalDependencies,m,n,newKey);
      char [][] candidatekey=new char[100][100];
      cm3.clear(candidatekey,100,100);

      int count1=0;
      for(int i=0;i<count;i++)
      {
        if(newKey[i][0]!='\0')
        {
          for(int j=0;newKey[i][j]!='\0';j++)
          {
            candidatekey[count1][j]=newKey[i][j];
          }
          count1++;
        }
      }
    //  CalculateMinimal cm=new CalculateMinimal();
      char [][] minimal=new char [100][100];
      int count2=cm3.calculateMinimal(functionalDependencies,m,n,minimal);
      int [] nfform=new int[count2];
      char [][] newTables=new char[100][100];
      //cm.clear(newTables,100,100);
      FindForm ff=new FindForm();
      ff.findForm(candidatekey,count1,minimal,count2,n,nfform);
      CalculateForm cf=new CalculateForm();
      int form=cf.calculateForm(nfform,count2);
      char [][] newTables1=new char[100][100];
      cm3.clear(newTables1,100,100);
      if(form==1)
      {
        NextForm nf=new NextForm();
        int noOfNewTables=nf.tonf2(minimal,count2,nfform,m,n,newTables1);
        String str100=findString(candidatekey,count1);
        printnf2(minimal,newTables1,noOfNewTables,n,str100,candidatekey,count1);
      }
      if(form>1)
      {
        finalAnswer.setText("The given FD are already in 2NF");
      }
    }
    if(ae.getActionCommand()=="3")
    {
      int n=findN();
      int m=findM(n);
      char [][] functionalDependencies=new char [m][100];
      CalculateMinimal cm3=new CalculateMinimal();
      cm3.clear(functionalDependencies,m,100);
      findingFunctionalDependencies(functionalDependencies,m);
      char [][] newKey=new char[100][100];
      cm3.clear(newKey,100,100);
      CalculateNewKey cnk=new CalculateNewKey();
      int count=cnk.calculatenewKey(functionalDependencies,m,n,newKey);
      char [][] candidatekey=new char[100][100];
      cm3.clear(candidatekey,100,100);

      int count1=0;
      for(int i=0;i<count;i++)
      {
        if(newKey[i][0]!='\0')
        {
          for(int j=0;newKey[i][j]!='\0';j++)
          {
            candidatekey[count1][j]=newKey[i][j];
          }
          count1++;
        }
      }
    //  CalculateMinimal cm=new CalculateMinimal();
      char [][] minimal=new char [100][100];
      int count2=cm3.calculateMinimal(functionalDependencies,m,n,minimal);
      int [] nfform=new int[count2];
      char [][] newTables=new char[100][100];
      //cm.clear(newTables,100,100);
      FindForm ff=new FindForm();
      ff.findForm(candidatekey,count1,minimal,count2,n,nfform);
      CalculateForm cf=new CalculateForm();
      int form=cf.calculateForm(nfform,count2);
      char [][] newTables1=new char[100][100];
      cm3.clear(newTables1,100,100);

      if(form<=2)
      {
        NextForm nf=new NextForm();
        CalculateMinimal cm10=new CalculateMinimal();
        char [][] newDependencies=new char[100][100];
        cm10.clear(newDependencies,100,100);
        count2=nf.combineMinimal(minimal,count2);
        int[] nfform1=new int [count2];
        ff.findForm(candidatekey,count1,minimal,count2,n,nfform1);
        nf.findOnlyKeyAttributes(candidatekey,count1,minimal,count2,newDependencies,n,nfform1);
        String str100=findString(candidatekey,count1);
        printnf3(minimal,newDependencies,n,str100,candidatekey,count1);
      }
      if(form>2)
      {
        finalAnswer.setText("The given FD are already in 3NF");
      }
    }
    if(ae.getActionCommand()=="4")
    {
      int n=findN();
      int m=findM(n);
      char [][] functionalDependencies=new char [m][100];
      CalculateMinimal cm3=new CalculateMinimal();
      cm3.clear(functionalDependencies,m,100);
      findingFunctionalDependencies(functionalDependencies,m);
      char [][] newKey=new char[100][100];
      cm3.clear(newKey,100,100);
      CalculateNewKey cnk=new CalculateNewKey();
      int count=cnk.calculatenewKey(functionalDependencies,m,n,newKey);
      char [][] candidatekey=new char[100][100];
      cm3.clear(candidatekey,100,100);

      int count1=0;
      for(int i=0;i<count;i++)
      {
        if(newKey[i][0]!='\0')
        {
          for(int j=0;newKey[i][j]!='\0';j++)
          {
            candidatekey[count1][j]=newKey[i][j];
          }
          count1++;
        }
      }
    //  CalculateMinimal cm=new CalculateMinimal();
      char [][] minimal=new char [100][100];
      int count2=cm3.calculateMinimal(functionalDependencies,m,n,minimal);
      int [] nfform=new int[count2];
      char [][] newTables=new char[100][100];
      //cm.clear(newTables,100,100);
      FindForm ff=new FindForm();
      ff.findForm(candidatekey,count1,minimal,count2,n,nfform);
      CalculateForm cf=new CalculateForm();
      int form=cf.calculateForm(nfform,count2);
      char [][] newTables1=new char[100][100];
      cm3.clear(newTables1,100,100);
      if(form<=3)
      {
        CalculateMinimal cm=new CalculateMinimal();
        NextForm nf=new NextForm();
        count2=nf.combineMinimal(minimal,count2);
        int[] nfform1=new int [count2];
        ff.findForm(candidatekey,count1,minimal,count2,n,nfform1);
        char [][]temp=new char[count2][100];
        cm.clear(temp,count2,100);
        int counter=findBCNF(minimal,count2,nfform1,n,temp);
        count2=0;
        for(int i=0;minimal[i][0]!='\0';i++)
        {
          count2++;
        }

        char[][] candidatekey1=new char [100][100];
        char[][] candidatekey2=new char [100][100];
        cm.clear(candidatekey1,100,100);
        cm.clear(candidatekey2,100,100);
        for(int i=0;i<count1;i++)
        {
          for(int j=0;candidatekey[i][j]!='\0';j++)
          {
            candidatekey1[i][j]=candidatekey[i][j];
          }
        }
        int noOfKeys=candidatekey(candidatekey1,count1,minimal,count2,n,candidatekey2);
        String str54=findString(candidatekey2,count1-noOfKeys);
        printnf4(candidatekey1,noOfKeys,minimal,temp,counter,n,str54);
      }
      if(form==4)
      {
        finalAnswer.setText("the given FD are already in BCNF");
      }
    }
  }
  public void printnf4(char candidatekey[][],int noOfKeys,char minimal[][],char newTables1[][],int count,int n,String pk)
  {
    finalAnswer.setText(null);
    int ijkl=0;
    int lkml=0;
    int r=0;
    for(int i=0;i<noOfKeys;i++)
    {
      int pointer=0;
      for(int j=0;candidatekey[i][j]!='\0';j++)
      {
        pointer++;
      }
      char [] key=new char [3*pointer];
      int pointer1=0;
      lkml=0;
      for(int j=0;candidatekey[i][j]!='\0';j++)
      {
        lkml++;
        key[pointer1++]=candidatekey[i][j];
        if(lkml!=pointer)
        {
          key[pointer1++]=',';
          key[pointer1++]=' ';
        }
      }
      char [] key1=new char[pointer];
      for(int j=0;candidatekey[i][j]!='\0';j++)
      {
        key1[j]=candidatekey[i][j];
      }
      String str54=new String(key1);
      String str=new String(key);
      finalAnswer.setText(finalAnswer.getText()+"R"+ijkl+r+":- {"+str+"} FD of R are as follows: NONE The Key is "+str54+"\n");
      //ijkl++;
      r++;
    }
    int counter=0;
    int [] vis=new int[n];
    CalculateNewKey cnk=new CalculateNewKey();
    cnk.putValue(vis,n,0);
    for(int i=0;minimal[i][0]!='\0';i++)
    {
      counter++;
      for(int j=0;minimal[i][j]!='\0';j++)
      {
        if(minimal[i][j]!='-'&&minimal[i][j]!='>')
        vis[minimal[i][j]-'a']=1;
      }
    }
    int sum=0;
    if(counter!=0)
    {
    for(int i=0;i<n;i++)
    {
      sum=sum+vis[i];
    }
    char[] attributes=new char[3*sum];
    attributes(vis,attributes,n,sum);
    String str=new String(attributes);
    String str1=findString(minimal,counter);
    finalAnswer.setText(finalAnswer.getText()+"R"+ijkl+":- { "+str+" } FD of R are as follows: "+str1+"The Key is "+pk+"\n");
  }
  int start=0;
  cnk.putValue(vis,n,0);
  for(int i=0;i<count;i++)
  {
    cnk.putValue(vis,n,0);
    for(int j=0;newTables1[i][j]!='\0';j++)
    {
      if(newTables1[i][j]!='-'&&newTables1[i][j]!='>')
      {
        vis[newTables1[i][j]-'a']=1;
      }
    }
    sum=0;
    for(int j=0;j<n;j++)
    {
      sum=sum+vis[j];
    }
    char[] attributes=new char[3*sum];
    attributes(vis,attributes,n,sum);
    String str=new String(attributes);
    int pointer=0;
    for(int j=0;newTables1[i][j]!='\0';j++)
    {
      pointer++;
    }
    char[] fd=new char [pointer];
    pointer=0;
    for(int j=0;newTables1[i][j]!='\0';j++)
    {
      fd[j]=newTables1[i][j];
    }
    String str2=new String(fd);
    for(int j=0;newTables1[i][j]!='-';j++)
    {
      pointer++;
    }
    char [] findingKey=new char [pointer];
    for(int j=0;newTables1[i][j]!='-';j++)
    {
      findingKey[j]=newTables1[i][j];
    }
    String str3=new String(findingKey);
    ijkl++;
    finalAnswer.setText(finalAnswer.getText()+"R"+ijkl+":- { "+str+" } FD of R are as follows: "+str2+"The Key is "+str3+"\n");

  }
  }
  public int candidatekey(char candidatekey[][],int count1,char minimal[][],int count2,int n,char candidatekey2[][])
  {
    CalculateMinimal cm=new CalculateMinimal();
    int [] vis=new int [n];
    int count100=0;
    for(int i=0;i<count2;i++)
    {
      for(int j=0;minimal[i][j]!='-';j++)
      {
        vis[minimal[i][j]-'a']=1;
      }
    }
    for(int i=0;i<count1;i++)
    {
      int flag=0;
      for(int j=0;candidatekey[i][j]!='\0';j++)
      {
        if(vis[candidatekey[i][j]-'a']==1)
        {
          continue;
        }
        else if(vis[candidatekey[i][j]-'a']==0)
        {
          flag=1;
          break;
        }
      }
      if(flag==0)
      {
        for(int j=0;candidatekey[i][j]!='\0';j++)
        {
          candidatekey2[count100][j]=candidatekey[i][j];
          candidatekey[i][j]='\0';
        }
        count100++;
      }
    }
    char [][] temp1=new char[100][100];
    cm.clear(temp1,100,100);
    int counter=0;
    for(int i=0;i<count1;i++)
    {
      if(candidatekey[i][0]!='\0')
      {
        for(int j=0;candidatekey[i][j]!='\0';j++)
        {
          temp1[counter][j]=candidatekey[i][j];
        }
        counter++;
      }
    }
    cm.clear(candidatekey,count1,100);
    for(int i=0;i<counter;i++)
    {
      for(int j=0;temp1[i][j]!='\0';j++)
      {
        candidatekey[i][j]=temp1[i][j];
      }
    }
    /*for(int i=0;i<counter;i++)
    {
      System.out.println(candidatekey[i]);
    }*/
    return counter;
  }
  public int findBCNF(char minimal[][],int count2,int nfform1[],int n,char temp[][])
  {
    int counter=0;
    CalculateMinimal cm=new CalculateMinimal();
    for(int i=0;i<count2;i++)
    {
      if(nfform1[i]==4)
      {
        continue;
      }
      if(nfform1[i]!=4)
      {
        for(int j=0;minimal[i][j]!='\0';j++)
        {
          temp[counter][j]=minimal[i][j];
          minimal[i][j]='\0';
        }
        counter++;
      }
    }
    char [][] temp1=new char[100][100];
    cm.clear(temp1,100,100);
    int count=0;
    for(int i=0;i<count2;i++)
    {
      if(minimal[i][0]!='\0')
      {
        for(int j=0;minimal[i][j]!='\0';j++)
        {
          temp1[count][j]=minimal[i][j];
        }
        count++;
      }
    }
    cm.clear(minimal,100,100);
    for(int i=0;i<count;i++)
    {
      for(int j=0;temp1[i][j]!='\0';j++)
      {
        minimal[i][j]=temp1[i][j];
      }
    }
    return counter;
  }
  public void printnf3(char minimal[][],char newTables1[][],int n,String pk,char candidatekey[][],int count1)
  {
    finalAnswer.setText(null);
    int counter=0;
    int [] vis=new int[n];
    CalculateNewKey cnk=new CalculateNewKey();
    cnk.putValue(vis,n,0);
    int ijkl=0;
    for(int i=0;minimal[i][0]!='\0';i++)
    {
      counter++;
      for(int j=0;minimal[i][j]!='\0';j++)
      {
        if(minimal[i][j]!='-'&&minimal[i][j]!='>')
        vis[minimal[i][j]-'a']=1;
      }
    }
    if(counter==0)
    {
      int r=0;
      for(int i=0;i<count1;i++)
      {
        int point=0;
        for(int j=0;candidatekey[i][j]!='\0';j++)
        {
          point++;
        }
        int flex=0;
        char [] key=new char[3*point];
        int pointer=0;
        for(int j=0;candidatekey[i][j]!='\0';j++)
        {
          flex++;
          key[pointer++]=candidatekey[i][j];
          if(flex!=point){
            key[pointer++]=',';
            key[pointer++]=' ';
          }
        }
        char [] key1=new char [point];
        for(int j=0;candidatekey[i][j]!='\0';j++)
        {
          key1[j]=candidatekey[i][j];
        }
        String str54=new String (key1);
        String str=new String(key);
        finalAnswer.setText(finalAnswer.getText()+"R"+ijkl+r+":- { "+str+" } FD of R are as follows: NONE The key is "+str54+"\n");
      //  ijkl++;
      r++;
      }
    }
    int sum=0;
    if(counter!=0)
    {
    for(int i=0;i<n;i++)
    {
      sum=sum+vis[i];
    }
    char[] attributes=new char[3*sum];
    attributes(vis,attributes,n,sum);
    String str=new String(attributes);
    String str1=findString(minimal,counter);
    finalAnswer.setText("R"+ijkl+":- { "+str+" } FD of R are as follows: "+str1+"The Key is "+pk+"\n");
  }
    int count=0;
    for(int i=0;newTables1[i][0]!='\0';i++)
    {
      count++;
    }
    //System.out.println(count);
    int start=0;
    cnk.putValue(vis,n,0);
    for(int i=0;i<count;i++)
    {
      cnk.putValue(vis,n,0);
      for(int j=0;newTables1[i][j]!='\0';j++)
      {
        if(newTables1[i][j]!='-'&&newTables1[i][j]!='>')
        {
          vis[newTables1[i][j]-'a']=1;
        }
      }
      sum=0;
      for(int j=0;j<n;j++)
      {
        sum=sum+vis[j];
      }
      char[] attributes=new char[3*sum];
      attributes(vis,attributes,n,sum);
      String str=new String(attributes);
      int pointer=0;
      for(int j=0;newTables1[i][j]!='\0';j++)
      {
        pointer++;
      }
      char[] fd=new char [pointer];
      pointer=0;
      for(int j=0;newTables1[i][j]!='\0';j++)
      {
        fd[j]=newTables1[i][j];
      }
      String str2=new String(fd);
      for(int j=0;newTables1[i][j]!='-';j++)
      {
        pointer++;
      }
      char [] findingKey=new char [pointer];
      for(int j=0;newTables1[i][j]!='-';j++)
      {
        findingKey[j]=newTables1[i][j];
      }
      String str3=new String(findingKey);
      ijkl++;
      finalAnswer.setText(finalAnswer.getText()+"R"+ijkl+":- { "+str+" } FD of R are as follows: "+str2+"The Key is "+str3+"\n");

    }
  }
  public void printnf2(char minimal[][],char newTables1[][],int count,int n,String pk,char candidatekey[][],int count1)
  {
    finalAnswer.setText(null);
    int [] vis=new int [n];
    CalculateNewKey cnk=new CalculateNewKey();
    cnk.putValue(vis,n,0);
    int counter=0;
    int ijkl=0;
    for(int i=0;minimal[i][0]!='\0';i++)
    {
      counter++;
      for(int j=0;minimal[i][j]!='\0';j++)
      {
        if(minimal[i][j]!='-'&&minimal[i][j]!='>')
        vis[minimal[i][j]-'a']=1;
      }
    }
    if(counter==0)
    {
      for(int i=0;i<count1;i++)
      {
        int point=0;
        for(int j=0;candidatekey[i][j]!='\0';j++)
        {
          point++;
        }
        int flex=0;
        char [] key=new char[3*point];
        int pointer=0;
        for(int j=0;candidatekey[i][j]!='\0';j++)
        {
          flex++;
          key[pointer++]=candidatekey[i][j];
          if(flex!=point){
            key[pointer++]=',';
            key[pointer++]=' ';
          }
        }
        char [] key1=new char[point];
        for(int j=0;candidatekey[i][j]!='\0';j++)
        {
          key1[j]=candidatekey[i][j];
        }
        String str54=new String(key1);
        String str=new String(key);
        finalAnswer.setText(finalAnswer.getText()+"R"+ijkl+":- { "+str+" } FD of R are as follows: NONE The key is "+str54+"\n");
        //ijkl++;
      }
    }
    int sum=0;
    if(counter!=0)
    {
    for(int i=0;i<n;i++)
    {
      sum=sum+vis[i];
    }
    char[] attributes=new char[3*sum];
      attributes(vis,attributes,n,sum);
    String str=new String(attributes);
    //System.out.println(counter);
    String str1=findString(minimal,counter);
    finalAnswer.setText("R"+ijkl+":- { "+str+" } FD of R are as follows: "+str1+"The Key is "+pk+"\n");
  }
    cnk.putValue(vis,n,0);
    int start=0;
    for(int i=0;i<count;i++)
    {
      if(newTables1[i][0]!='\0')
      {
        for(int j=0;newTables1[i][j]!='\0';j++)
        {
          if(newTables1[i][j]!='-'&&newTables1[i][j]!='>')
          {
            vis[newTables1[i][j]-'a']=1;
          }
        }
      }
      else if(newTables1[i][0]=='\0')
      {
        sum=0;
        for(int j=0;j<n;j++)
        {
          sum=sum+vis[j];
        }
        char[] attributes1=new char[3*sum];
        attributes(vis,attributes1,n,sum);
        String str100=new String(attributes1);
        int pointer=0;
        for(int j=start;j<i;j++)
        {
          for(int l=0;newTables1[j][l]!='\0';l++)
          {
            pointer++;
          }
        }
        char[] finalAnswer1=new char[pointer+i-start+i-start];
        pointer=0;
        for(int j=start;j<i;j++)
        {
          for(int l=0;newTables1[j][l]!='\0';l++)
          {
            finalAnswer1[pointer++]=newTables1[j][l];
          }
          if(j!=start-1)
          {
            finalAnswer1[pointer++]=',';
            finalAnswer1[pointer++]=' ';
          }
        }
        String str2=new String(finalAnswer1);
        ijkl++;
        int [] vis1=new int [n];
        cnk.putValue(vis1,n,0);
        int sum1=0;
        for(int j=0;j<str2.length();j++)
        {
          if(str2.charAt(j)=='-')
          {
            break;
          }
          vis1[str2.charAt(j)-'a']=1;
          sum1++;
        }
        char[] primaryKey=new char[sum1];
        int pointer1=0;
        for(int j=0;j<n;j++)
        {
          if(vis1[j]==1)
          {
            primaryKey[pointer1++]=(char)(j+97);
          }
        }
        String str5=new String(primaryKey);
        String str3=("R"+ijkl+":- { "+str100+" } FD of R are as follows: "+str2+" The Key is "+str5+"\n");
        String str4=finalAnswer.getText();
        finalAnswer.setText(str4+str3);
        start=i+1;
        cnk.putValue(vis,n,0);
      }
    }
  }
  void attributes(int vis[],char attributes[],int n,int sum)
  {
    int sum1=0;
    int pointer=0;
    for(int i=0;i<n;i++)
    {
      if(vis[i]==1)
      {
        attributes[pointer++]=(char)(i+97);
        sum1++;
        if(sum1!=sum)
        {
          attributes[pointer++]=',';
          attributes[pointer++]=' ';
        }
      }
    }
  }
  public String findString(char candidatekey[][],int count1)
  {
    int pointer=0;
    for(int i=0;i<count1;i++)
    {
      for(int j=0;candidatekey[i][j]!='\0';j++)
      {
        pointer++;
      }
    }
    /*for(int i=0;i<count1;i++)
    {
      System.out.println(candidatekey[i]);
    }*/
    //System.out.println(pointer);
    if(pointer==0)
    return null;
    char[] finalAnswer=new char[pointer+count1+count1-1];
    pointer=0;
    for(int i=0;i<count1;i++)
    {
      for(int j=0;candidatekey[i][j]!='\0';j++)
      {
        finalAnswer[pointer++]=candidatekey[i][j];
      }
      if(i!=count1-1)
      {
        finalAnswer[pointer++]=',';
        finalAnswer[pointer++]=' ';
      }
    }
    String str1=new String(finalAnswer);
    return str1;
  }
  public static void  createDialogBox(JFrame jfrm)
  {
    JDialog d=new JDialog(jfrm,"Dialog box");
    JLabel l = new JLabel("Please Enter Valid Inputs");
    l.setFont(new Font(l. getName(), Font. PLAIN,20));
    d.add(l);
    d.setSize(250, 150);
    d.setBounds(150,350,250,100);
    d.setVisible(true);
  }
  public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					//window.jfrm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();

				}
			}
		});

}
}
class NextForm
{
  void calculatePresentForm(char candidatekey[][],int count,char dependencies[][],int m,int n)
  {
    CalculateMinimal cm=new CalculateMinimal();
    char [][] minimal=new char [100][100];
    int count1=cm.calculateMinimal(dependencies,m,n,minimal);
    /*for(int i=0;i<count1;i++)
    {
      System.out.println(minimal[i]);
    }*/
    int [] nfform=new int[count1];
    char [][] newTables=new char[100][100];
    cm.clear(newTables,100,100);
    FindForm ff=new FindForm();
    ff.findForm(candidatekey,count,minimal,count1,n,nfform);
    CalculateForm cf=new CalculateForm();
    int form=cf.calculateForm(nfform,count1);
    //count1=combineMinimal(minimal,count1);// do remove it
    /*for(int i=0;i<count1;i++)
    {
      System.out.println(minimal[i]);
    }*/
    if(form==1)
    {
      int count100=tonf2(minimal,count1,nfform,m,n,newTables);// new tables me el tables hai new and woh saari ek line chod k hai tph dekh k
    }
    if(form==2)
    {
      char [][] newDependencies=new char[100][100];
      cm.clear(newDependencies,100,100);
      count1=combineMinimal(minimal,count1);
      int[] nfform1=new int [count1];
      ff.findForm(candidatekey,count,minimal,count1,n,nfform1);
      findOnlyKeyAttributes(candidatekey,count,minimal,count1,newDependencies,n,nfform1); // new dependencies me ahr ek new line ek new table represent kaerti hai
    }
    if(form==3)
    {
      count1=combineMinimal(minimal,count1);
      int[] nfform1=new int [count1];
      ff.findForm(candidatekey,count,minimal,count1,n,nfform1);
      char [][]temp=new char[20][100];
      cm.clear(temp,count1,100);
      char[][] minimal1=new char[count1][100];
      for(int i=0;i<count1;i++)
      {
        for(int j=0;minimal[i][j]!='\0';j++)
        {
          minimal1[i][j]=minimal[i][j];
        }
      }
      int counter=segregateToBCNF(minimal1,count1,nfform1,n,temp);

      char [][] tables=new char[counter][100];
      cm.clear(tables,counter,100);
      findRelations(minimal,count1,temp,counter,candidatekey,n,count,tables);//tables me final answer hai with counter as its size
    }
  }
  void findRelations(char minimal[][],int count1,char temp[][],int counter,char candidatekey[][],int n,int count,char tables[][])
  {
    int [] vis=new int[n];
    //int count=0;
    int flag1=0;
    CalculateNewKey cnk=new CalculateNewKey();
    cnk.putValue(vis,n,1);
    for(int i=0;i<counter;i++)
    {
      cnk.putValue(vis,n,0);
      for(int j=0;temp[i][j]!='\0';j++)
      {
        vis[temp[i][j]-'a']=1;
      }
      for(int j=0;j<count1;j++)
      {
        int flag=0;
        for(int l=0;minimal[j][l]!='\0';l++)
        {
          if(minimal[j][l]!='-'&&minimal[j][l]!='>')
          {
            if(vis[minimal[j][l]-'a']==1)
            {
              continue;
            }
            else if(vis[minimal[j][l]-'a']==0)
            {
              flag=1;
              break;
            }
          }
        }
         flag1=0;
        if(flag==0)
        {
          for(int l=0;minimal[j][l]!='\0';l++)
          {
            tables[i][l]=minimal[j][l];
          }
          flag1=1;
          break;
        }
      }
      if(flag1==0)
      {
      //  System.out.println("the value of  i is "+i );
        for(int l=0;temp[i][l]!='\0';l++)
        {
          tables[i][l]=temp[i][l];
        }
      }
    }
    int pointer=0;
    int flag=0;
    for(int i=0;;i++)
    {
      if(tables[counter-1][i]=='\0')
      {
        break;
      }
      if(tables[counter-1][i]=='-')
      {
        flag=1;
        break;
      }
    }
    int [] vis2=new int [n];
    cnk.putValue(vis2,n,0);
    cnk.putValue(vis,n,0);
    if(flag==0)
    {
      for(int i=0;tables[counter-1][i]!='\0';i++)
      {
        tables[counter-1][i]='\0';
      }
      for(int i=0;temp[counter-1][i]!='\0';i++)
      {
        vis[temp[counter-1][i]-'a']=1;
      }
      for(int i=0;i<count;i++)
      {
        cnk.putValue(vis2,n,0);
        for(int j=0;candidatekey[i][j]!='\0';j++)
        {
          vis2[candidatekey[i][j]-'a']=1;
        }
        flag1=0;
        for(int j=0;j<n;j++)
        {
          if(vis2[j]==1)
          {
            if(vis[j]==1)
            {
              continue;
            }
            else if(vis[j]==0)
            {
              flag1=1;
              break;
            }
          }
        }
        if(flag1==0)
        {
          for(int j=0;candidatekey[i][j]!='\0';j++)
          {
            tables[counter-1][j]=candidatekey[i][j];
          }
          break;
        }
      }
    }
    for(int i=0;i<counter;i++)
    {
      System.out.println(tables[i]);
    }
  }
  int segregateToBCNF(char minimal[][],int count1,int nfform[],int n,char temp[][])
  {
    int [] vis=new int[n];
    int [] vis1=new int[n];
    int [] vis2=new int[n];
    CalculateNewKey cnk=new CalculateNewKey();
    cnk.putValue(vis,n,1);
    cnk.putValue(vis1,n,0);
    cnk.putValue(vis2,n,0);
    char [][] newDependencies=new char [100][100];
    CalculateMinimal cm=new CalculateMinimal();
    cm.clear(newDependencies,100,100);
    int pointer=0;
    int [][] newTables=new int [count1][n];
    putZero(newTables,count1,n);
    //System.out.println("i am sweet");
    int count=0;
    int counter=0;
    for(int i=0;i<count1;i++)
    {
      count=0;
      //System.out.println("i am ");
      if(minimal[i][0]=='\0')
      {
        continue;
      }
      //System.out.println("rishab");
      if(nfform[i]<=3)
      {
        putZero(newTables,count1,n);
        cm.clear(newDependencies,100,100);
        cnk.putValue(vis1,n,0);
        pointer=0;
        //System.out.println("rishab");
        for(int j=0;;j++)
        {
          if(minimal[i][j]=='>')
          {
            pointer=j;
            break;
          }
        }
        pointer++;
        for(int j=pointer;minimal[i][j]!='\0';j++)
        {
          vis1[minimal[i][j]-'a']=1;
        }
        for(int j=0;j<n;j++)
        {
          vis[j]=vis[j]-vis1[j];
        }
        for(int j=0;minimal[i][j]!='\0';j++)
        {
          newDependencies[count][j]=minimal[i][j];
          minimal[i][j]='\0';
        }
        count++;
        nfform[i]=0;
        while(true)
        {
          int initialCount=count;
          for(int j=0;j<count1;j++)
          {
            if(i==j||minimal[j][0]=='\0')
            {
              continue;
            }
            else if(i!=j)
            {
              int flag=0;
              if(nfform[j]<=3)
              {
                for(int l=0;minimal[j][l]!='-';l++)
                {
                  if(vis1[minimal[j][l]-'a']==1)
                  {
                    continue;
                  }
                  else if(vis1[minimal[j][l]-'a']==0)
                  {
                    flag=1;
                    break;
                  }
                }
                if(flag==0)
                {
                  int pointer1=0;
                  for(int l=0;;l++)
                  {
                    if(minimal[j][l]=='>')
                    {
                      pointer1=l;
                      break;
                    }
                  }
                  pointer1++;
                  for(int l=pointer;minimal[j][l]!='\0';l++)
                  {
                    vis1[minimal[j][l]-'a']=1;
                  }
                  for(int l=0;minimal[j][l]!='\0';l++)
                  {
                    newDependencies[count][l]=minimal[j][l];
                    minimal[j][l]='\0';
                  }
                  nfform[j]=0;
                  count++;
                }

              }
            }
          }
          if(initialCount==count)
          {
            break;
          }
        }
        calculateAttributes(newDependencies,count,newTables);
        /*for(int j=0;j<count;j++)
        {
          for(int l=0;l<n;l++)
          System.out.print(newTables[j][l]+" ");
          System.out.println();
        }*/
        for(int j=0;j<count;j++)
        {
          int pointer2=0;
          int flag3=0;
          for(int l=0;l<n;l++)
          {
            if(newTables[j][l]==1)
            {
              flag3=1;
              temp[counter][pointer2++]=(char)(l+97);
            }
          }
          if(flag3==1)
          {
            counter++;
          }
        }
      }
    }
    //System.out.println(counter+" "+count1);
    int flag=0;
    int pointer2=0;
    for(int i=0;i<n;i++)
    {
      if(vis[i]==1)
      {
        flag=1;
        temp[counter][pointer2++]=(char)(i+97);
      }
    }
    if(flag==1)
    {
      counter++;
    }
    return counter;
  }
  void calculateAttributes(char newDependencies[][],int count,int newTable[][])
  {
    int pointer=0;
    for(int i=0;i<count;i++)
    {
      if(i==0)
      {
        for(int j=0;newDependencies[i][j]!='\0';j++)
        {
          if(newDependencies[i][j]!='-'&&newDependencies[i][j]!='>')
          {
            newTable[i][newDependencies[i][j]-'a']=1;
          }
        }
      }
      if(i!=0)
      {
        for(int j=0;newDependencies[i][j]!='\0';j++)
        {
          if(newDependencies[i][j]!='-'&&newDependencies[i][j]!='>')
          {
            newTable[i][newDependencies[i][j]-'a']=1;
          }
        }
        pointer=0;
        for(int j=0;;j++)
        {
          if(newDependencies[i][j]=='>')
          {
            pointer=j;
            break;
          }
        }
        pointer++;
        for(int j=pointer;newDependencies[i][j]!='\0';j++)
        {
          newTable[i-1][newDependencies[i][j]-'a']=0;
        }
      }
    }
  }
  void putZero(int temp[][],int r,int c)
  {
    for(int i=0;i<r;i++)
    {
      for(int j=0;j<c;j++)
      {
        temp[i][j]=0;
      }
    }
  }
  void findOnlyKeyAttributes(char candidatekey[][],int count,char minimal[][],int count1,char newDependencies[][],int n,int nfform[])
  {
    int [] vis=new int [n];
    int [] vis1=new int [n];
    CalculateNewKey cnk=new CalculateNewKey();
    cnk.putValue(vis,n,0);
    cnk.putValue(vis1,n,0);
    for(int i=0;i<count;i++)
    {
      for(int j=0;candidatekey[i][j]!='\0';j++)
      {
        vis[candidatekey[i][j]-'a']=1;
      }
    }
    int pointer=0;
    int counter=0;
    int pointer1=0;
    int flag=0;
    for(int i=0;i<count1;i++)
    {
      if(nfform[i]>=3)
      {
        continue;
      }
      for(int j=0;;j++)
      {
        if(minimal[i][j]=='>')
        {
          pointer=j;
          break;
        }
      }
      pointer++;
      for(int j=pointer;minimal[i][j]!='\0';j++)
      {
        if(vis[minimal[i][j]-'a']==1)
        {
          continue;
        }
        else if(vis[minimal[i][j]-'a']==0)
        {
          vis1[minimal[i][j]-'a']=1;
          flag=1;
          if(newDependencies[counter][0]=='\0')
          {
            pointer1=0;
            for(int l=0;minimal[i][l]!='>';l++)
            {
              newDependencies[counter][l]=minimal[i][l];
              pointer1++;
            }
            newDependencies[counter][pointer1++]='>';
          }
          newDependencies[counter][pointer1++]=minimal[i][j];
          minimal[i][j]='\0';
        }
      }
      if(flag==1)
      {
        counter++;
      }
      flag=0;
    }
    count1=correctMinimal(minimal,count1,vis1,n);
    /*System.out.println("these are the new tables");
    for(int i=0;i<counter;i++)
    {
      System.out.println(newDependencies[i]);
    }
    System.out.println("these are the existing tables");
    for(int i=0;i<count1;i++)
    {
      System.out.println(minimal[i]);
    }*/
  }
  int correctMinimal(char minimal[][],int count1,int vis1[],int n)
  {

    int pointer=0;
    int flag=0;
    int flag1=0;
    for(int i=0;i<count1;i++)
    {
      flag1=0;
      for(int j=0;minimal[i][j]!='-';j++)
      {
        if(vis1[minimal[i][j]-'a']==1)
        {
          //System.out.println("giberish");
          for(int l=0;minimal[i][l]!='\0';l++)
          {
            minimal[i][l]='\0';
          }
          flag1=1;
          break;
        }
      }
      if(flag1==0)
      {
        pointer=0;
        for(int j=0;;j++)
        {
          if(minimal[i][j]=='>')
          {
            pointer=j;
            break;
          }
        }
        int initialPointer;
        pointer++;
        initialPointer=pointer;
        flag=0;
        for(int j=pointer;j<100;j++)
        {
          if(minimal[i][j]=='\0')
          {
            continue;
          }
          else if(minimal[i][j]!='\0')
          {
            minimal[i][initialPointer++]=minimal[i][j];
            if(initialPointer-1!=j)
            {
              minimal[i][j]='\0';
            }
            flag=1;
          }
        }
        if(flag==0)
        {
          for(int l=0;minimal[i][l]!='\0';l++)
          {
            minimal[i][l]='\0';
          }
        }
      }
    }
    char[][] temp=new char[count1][100];
    int count=0;
    for(int i=0;i<count1;i++)
    {
      if(minimal[i][0]!='\0')
      {
        for(int j=0;minimal[i][j]!='\0';j++)
        {
          temp[count][j]=minimal[i][j];
        }
        count++;
      }
    }
    CalculateMinimal cm=new CalculateMinimal();
    cm.clear(minimal,count1,100);
    for(int i=0;i<count;i++)
    {
      for(int j=0;temp[i][j]!='\0';j++)
      {
        minimal[i][j]=temp[i][j];
      }
    }
    return count;
  }
  void tonf3(char minimal[][],int count1,int nfform[],int m,int n,char newTables[][])
  {
    int count=0;
    for(int i=0;i<count1;i++)
    {
      if(nfform[i]<=2)
      {
        for(int j=0;minimal[i][j]!='\0';j++)
        {
          newTables[count][j]=minimal[i][j];
          minimal[i][j]='\0';
        }
        count++;
      }
    }
  }
  int combineMinimal(char minimal[][],int count1)
  {
    char [][] temp=new char[count1][100];
    CalculateMinimal cm=new CalculateMinimal();
    cm.clear(temp,count1,100);
    int count=0;
    int pointer=0;
    char [] vis=new char [100];
    char [] vis1=new char[100];
    doNull(vis);
    doNull(vis1);
    for(int i=0;minimal[0][i]!='-';i++)
    {
      vis[i]=minimal[0][i];
    }
    String str1=new String(vis);
    for(int i=0;i<count1;i++)
    {
      doNull(vis1);
      for(int j=0;minimal[i][j]!='-';j++)
      {
        vis1[j]=minimal[i][j];
      }
      String str2=new String(vis1);
    //  System.out.println(" the Str1 is "+str1+" the str2 is "+str2+" "+count);
      if(str1.equals(str2))
      {
        if(temp[count][0]=='\0')
        {
          pointer=0;
          for(int j=0;vis[j]!='\0';j++)
          {
            temp[count][j]=vis[j];
            pointer++;
          }
          temp[count][pointer++]='-';
          temp[count][pointer++]='>';
        }
        int pointer1=0;
        for(int j=0;;j++)
        {
          if(minimal[i][j]=='>')
          {
            pointer1=j;
            break;
          }
        }
        pointer1++;
        temp[count][pointer++]=minimal[i][pointer1];
      }
      if(!(str1.equals(str2)))
      {
        count++;
        pointer=0;
        for(int j=0;vis1[j]!='\0';j++)
        {
          temp[count][j]=vis1[j];
          pointer++;
        }
        temp[count][pointer++]='-';
        temp[count][pointer++]='>';
        int pointer1=0;
        for(int j=0;;j++)
        {
          if(minimal[i][j]=='>')
          {
            pointer1=j;
            break;
          }
        }
        pointer1++;
        temp[count][pointer++]=minimal[i][pointer1];
        str1=str2;
      }

    }
    /*for(int i=0;i<count+1;i++)
    {
      System.out.println(temp[i]);
    }*/
    cm.clear(minimal,count1,100);
    for(int i=0;i<count+1;i++)
    {
      for(int j=0;temp[i][j]!='\0';j++)
      {
        minimal[i][j]=temp[i][j];
      }
    }
    return count+1;
  }
  void doNull(char str[] )
  {
    for(int i=0;i<100;i++)
    {
      str[i]='\0';
    }
  }
  int tonf21(char newTables [][],int count,int n )
  {
    int start=0;
    int [] vis=new int [n];
    int [] vis1=new int [n];
    CalculateNewKey cnk=new CalculateNewKey();
    char [][] newDependencies=new char[100][100];
    char [][] previousDependencies=new char[100][100];
    CalculateMinimal cm=new CalculateMinimal();
    cm.clear(newDependencies,100,100);
    cm.clear(previousDependencies,100,100);
    int pcounter=0;
    int ncounter=0;
    cnk.putValue(vis,n,0);
    /*for(int i=0;i<count;i++)
    {
      System.out.println(newTables[i]);
    }*/
    for(int i=0;i<count;i++)
    {
      if(newTables[i][0]!='\0')
      {
        if(i==start)
        {
          cnk.putValue(vis,n,0);
          for(int j=0;newTables[i][j]!='-';j++)
          {
            vis[newTables[i][j]-'a']=1;
          }
          for(int j=0;newTables[i][j]!='\0';j++)
          {
            previousDependencies[pcounter][j]=newTables[i][j];
          }
          pcounter++;
        }
        else if(i!=start)
        {
          cnk.putValue(vis1,n,0);
          for(int j=0;newTables[i][j]!='-';j++)
          {
            vis1[newTables[i][j]-'a']=1;
          }
          int flag=0;
          for(int j=0;j<n;j++)
          {
            if(vis1[j]==1)
            {
              if(vis[j]==1)
              {
                continue;
              }
              if(vis[j]==0)
              {
                flag=1;
                break;
              }
            }
          }
          if(flag==0)
          {
            for(int j=0;j<n;j++)
            {
              if(vis[j]!=vis1[j])
              {
                flag=0;
                break;
              }
              if(j==n-1)
              {
                flag=1;
              }
            }
          }
          if(flag==0)
          {
            for(int j=0;newTables[i][j]!='\0';j++)
            {
              newDependencies[ncounter][j]=newTables[i][j];
            }
            //System.out.println(newDependencies[ncounter]);
            ncounter++;
          }
          if(flag==1)
          {
            for(int j=0;newTables[i][j]!='\0';j++)
            {
              previousDependencies[pcounter][j]=newTables[i][j];
            }
            pcounter++;
          }
        }
      }
      else if(newTables[i][0]=='\0')
      {
        pcounter++;
        start=i+1;
      }
    }
    /*System.out.println("These are the previous tables");
    for(int i=0;i<pcounter;i++)
    {
      System.out.println(previousDependencies[i]);
    }
    System.out.println("These are new Tables");
    for(int i=0;i<ncounter;i++)
    {
      System.out.println(newDependencies[i]);
    }*/
    //System.out.println(previousDependencies[pcounter-1]);
    for(int i=0;i<ncounter;i++)
    {
      for(int j=0;newDependencies[i][j]!='\0';j++)
      {
        previousDependencies[pcounter][j]=newDependencies[i][j];
      }
      if(i!=n-1){
        pcounter++;
        pcounter++;
      }
      if(i==n-1)
      {
        pcounter++;
      }
    }
    cm.clear(newTables,100,100);
    for(int i=0;i<pcounter;i++)
    {
      for(int j=0;j<100;j++)
      {
        newTables[i][j]=previousDependencies[i][j];
      }
    }
    return pcounter;
  }
  int tonf2(char minimal[][],int count1,int nfform[],int m,int n,char newTables[][])
  {
    int [] vis =new int[n];
    int [] vis1=new int[n];
    int [] vis2=new int [n];
    int count=0;
    int pointer=0;
    CalculateNewKey cnk=new CalculateNewKey();
    CalculateMinimal cm=new CalculateMinimal();
    cnk.putValue(vis2,n,0);
    cm.clear(newTables,100,100);
    for(int i=0;i<count1;i++)
    {
      if(nfform[i]==1)
      {
        //cm.clear(newTables,100,100);
        cnk.putValue(vis,n,0);
        cnk.putValue(vis1,n,0);
        //count=0;
        pointer=0;
        for(int j=0;minimal[i][j]!='-';j++)
        {
          vis[minimal[i][j]-'a']=1;
        }
        for(int j=0;;j++)
        {
          if(minimal[i][j]=='>')
          {
            pointer=j;
            break;
          }
        }
        pointer++;
        vis[minimal[i][pointer]-'a']=1;
        vis1[minimal[i][pointer]-'a']=1;
        vis2[minimal[i][pointer]-'a']=1;
        for(int j=0;minimal[i][j]!='\0';j++)
        {
          newTables[count][j]=minimal[i][j];
          minimal[i][j]='\0';
        }
        nfform[i]=0;
        count++;
        while(true)
        {
          int initialCount=count;
          for(int j=0;j<count1;j++)
          {
            if(i==j||minimal[j][0]=='\0'||nfform[j]>2)
            {
              continue;
            }
            else if(i!=j)
            {
              int flag=0;
              for(int l=0;minimal[j][l]!='-';l++)
              {
              //  System.out.println("valueof "+i+" "+j);
                if(vis[minimal[j][l]-'a']==1)
                {
                  continue;
                }
                else if(vis[minimal[j][l]-'a']==0)
                {
                  flag=1;
                  break;
                }
              }
              if(flag==0)
              {
                pointer=0;
                for(int l=0;;l++)
                {
                  if(minimal[j][l]=='>')
                  {
                    pointer=l;
                    break;
                  }
                }
                pointer++;
                vis[minimal[j][pointer]-'a']=1;
                vis1[minimal[j][pointer]-'a']=1;
                vis2[minimal[j][pointer]-'a']=1;
                for(int l=0;minimal[j][l]!='\0';l++)
                {
                  newTables[count][l]=minimal[j][l];
                  minimal[j][l]='\0';
                }
                nfform[j]=0;
                count++;
              }
              if(flag!=0)
              {
                boolean bo=checkonce(minimal,j,vis1,n);
                if(bo==true)
                {
                  for(int l=0;minimal[j][l]!='\0';l++)
                  {
                    minimal[j][l]='\0';
                  }
                  nfform[j]=0;
                }
              }
            }
          }
          if(initialCount==count)
          {
            break;
          }
        }
        count++;
      }
    }
    for(int i=0;i<count1;i++)
    {
      if(minimal[i][0]=='\0')
      {
        continue;
      }
      boolean bo=checkonce(minimal,i,vis2,n);
      if(bo==true)
      {
        for(int j=0;minimal[i][j]!=0;j++)
        {
          minimal[i][j]='\0';
        }
      }
    }
    char [][] temp100=new char [count1][100];
    CalculateMinimal cm10=new CalculateMinimal();
    cm10.clear(temp100,count1,100);
    int counter100=0;
    /*for(int i=0;i<count1;i++)
    {
      System.out.println(minimal[i]);
    }*/
    for(int i=0;i<count1;i++)
    {
      if(minimal[i][0]!='\0')
      {
        for(int j=0;minimal[i][j]!='\0';j++)
        {
          temp100[counter100][j]=minimal[i][j];
        }
        counter100++;
      }
    }
    cm10.clear(minimal,count1,100);
    for(int i=0;i<counter100;i++)
    {
      for(int j=0;temp100[i][j]!='\0';j++)
      {
        minimal[i][j]=temp100[i][j];
      }
    }
    /*System.out.println("Existing Tables are as follows");
    for(int i=0;i<count1;i++)
    {
      System.out.println(minimal[i]);
    }
    System.out.println("The new tables are as follow");
    for(int i=0;i<count;i++)
    {
      System.out.println(newTables[i]);
    }*/
    count=tonf21(newTables,count,n);
    /*for(int i=0;i<count;i++)
    {
      System.out.println(newTables[i]);
    }*/
    return count;
    //return 0;
  }
  boolean checkonce(char minimal[][],int pointer,int vis[],int n)
  {
    for(int i=0;minimal[pointer][i]!='-';i++)
    {
      if(vis[minimal[pointer][i]-'a']==1)
      {
        return true;
      }
    }
    return false;
  }
}
class FindForm
{
  void findForm(char candidatekey[][],int count,char dependencies[][],int m,int n,int nfform[])
  {
    for(int i=0;i<m;i++)
    {
      nfform[i]=1;
    }
    CalculateForm cf=new CalculateForm();
    for(int i=0;i<m;i++)
    {
      boolean bo;
      if(cf.bcnf(candidatekey,count,dependencies,m,i,n))
      {
        nfform[i]=4;
        continue;
      }
      if(cf.nf3(candidatekey,count,dependencies,m,i,n))
      {
        nfform[i]=3;
        continue;
      }
      else if(cf.nf2(candidatekey,count,dependencies,m,i,n))
      {
        nfform[i]=2;
        continue;
      }
    }
  }
}
class CalculateForm
{
  int calculateForm(int nfform[],int m)
  {
    int max=4;
    for(int i=0;i<m;i++)
    {
      if(nfform[i]<max&&nfform[i]!=0)
      {
        max=nfform[i];
      }
    }
    return max;
  }
  boolean bcnf(char candidatekey[][],int count,char dependencies[][],int m,int pointer,int n)
  {
    int[] vis=new int [n];
    int [] vis1=new int [n];
    CalculateNewKey cnk=new CalculateNewKey();
    cnk.putValue(vis,n,0);
    cnk.putValue(vis1,n,0);
    for(int i=0;dependencies[pointer][i]!='-';i++)
    {
      vis1[dependencies[pointer][i]-'a']=1;
    }
    for(int i=0;i<count;i++)
    {
      cnk.putValue(vis,n,0);
      for(int j=0;candidatekey[i][j]!='\0';j++)
      {
        vis[candidatekey[i][j]-'a']=1;
      }
      int flag=0;
      for(int j=0;j<n;j++)
      {
        if(vis[j]==1)
        {
          if(vis1[j]==0)
          {
            flag=1;
            break;
          }
          else if(vis1[j]==1)
          {
            continue;
          }
        }
      }
      if(flag==0)
      {
        return true;
      }
    }
    return false;
  }
  boolean nf3(char candidatekey[][],int count,char dependencies[][],int m,int pointer,int n)
  {
    int [] vis=new int[n];
    int pointer1=0;
    CalculateNewKey cnk=new CalculateNewKey();
    cnk.putValue(vis,n,0);
    for(int i=0;i<count;i++)
    {
      for(int j=0;candidatekey[i][j]!='\0';j++)
      {
        vis[candidatekey[i][j]-'a']=1;
      }
    }
    for(int i=0;;i++)
    {
      if(dependencies[pointer][i]=='>')
      {
        pointer1=i;
        break;
      }
    }
    pointer1++;
    for(int i=pointer1;dependencies[pointer][i]!='\0';i++)
    {
      if(vis[dependencies[pointer][i]-'a']==1)
      {
          continue;
      }
      else if(vis[dependencies[pointer][i]-'a']==0)
      {
        return false;
      }
    }
    return true;
  }
  boolean nf2(char candidatekey[][],int count,char dependencies[][],int m,int pointer,int n)
  {
    int [] vis=new int [n];
    int [] vis1=new int [n];
    CalculateNewKey cnk=new CalculateNewKey();
    cnk.putValue(vis,n,0);
    cnk.putValue(vis1,n,0);
    for(int i=0;dependencies[pointer][i]!='-';i++)
    {
      vis1[dependencies[pointer][i]-'a']=1;
    }
    for(int i=0;i<count;i++)
    {
      cnk.putValue(vis,n,0);
      for(int j=0;candidatekey[i][j]!='\0';j++)
      {
        vis[candidatekey[i][j]-'a']=1;
      }
      int flag=0;
      for(int j=0;j<n;j++)
      {
        if(vis1[j]==1)
        {
          if(vis[j]==0)
          {
            flag=1;
            break;
          }
          if(vis[j]==1)
          {
            continue;
          }
        }
      }
      if(flag==0)
      {
        return false;
      }
    }
    return true;
  }
}
class CalculateNewKey
{
  int calculatenewKey(char dependencies[][],int m,int n,char newKey[][])
  {
    CalculateMinimal cm=new CalculateMinimal();
    char [][] minimal=new char [100][100];
    int count=cm.calculateMinimal(dependencies,m,n,minimal);
    /*for(int i=0;i<count;i++)
    {
      System.out.println(minimal[i]);
    }*/
    int [] vis=new int [n];
    putValue(vis,n,1);
    notOnRhs(vis,n,minimal,count);
    /*for(int i=0;i<n;i++)
    {
      System.out.println(vis[i]);
    }*/
    int [] vis1=new int [n];
    onRhsNotOnLhs(vis1,n,minimal,count);
    /*for(int i=0;i<n;i++)
    {
      System.out.println(vis1[i]);
    }*/
    calculateClosure(vis,n,minimal,count);
    /*for(int i=0;i<n;i++)
    {
      System.out.println(vis[i]);
    }*/
    int [] vis2=new int[n];
    putValue(vis2,n,1);
    findAttributes(vis2,vis1,vis,n);
    /*for(int i=0;i<n;i++)
    {
      System.out.println(vis2[i]);
    }*/
    int size=0;
    for(int i=0;i<n;i++)
    {
      if(vis2[i]==1)
      {
        size++;
      }
    }
    char [] set=new char[size];
    int counter=0;
    for(int i=0;i<n;i++)
    {
      if(vis2[i]==1)
      {
        set[counter++]=(char)(i+'a');
      }
    }
    //Arrays.sort(set);
    /*for(int i=0;i<size;i++)
    {
      System.out.print(set[i]);
    }*/

    int power=calculatePower(size);
    //System.out.println(power);
    char[][] subset=new char[power][100];
    cm.clear(subset,power,100);
    calculateSubset(set,size,subset,power);
    /*for(int i=0;i<power;i++)
    {
      System.out.println(subset[i]);
    }*/
    int noOfKeys=0;
    cm.clear(newKey,100,100);
    putValue(vis,n,1);
    notOnRhs(vis,n,minimal,count);
    essentialAttributes(newKey,vis,n);
    //System.out.println(newKey[0]);
    noOfKeys=findingKeys(subset,power,vis,n,newKey,minimal,count);
    findingOnlyCandidates(newKey,noOfKeys,n);
    return noOfKeys;
  }
  void findingOnlyCandidates(char newKey[][],int noOfKeys,int n)
  {
    for(int i=0;i<noOfKeys;i++)
    {
      deletingSuperKeys(newKey,noOfKeys,i,n);
    }
  }
  void deletingSuperKeys(char newKey[][],int noOfKeys,int pointer,int n)
  {
    if(newKey[pointer][0]=='\0')
    {
      //System.out.println(pointer);
      return ;
    }
    int [] vis=new int [n];
    int [] vis1=new int [n];
    putValue(vis,n,0);
    putValue(vis1,n,0);
    for(int i=0;newKey[pointer][i]!='\0';i++)
    {
      vis[newKey[pointer][i]-'a']=1;
    }
    for(int i=0;i<noOfKeys;i++)
    {
      if(pointer==i)
      {
        continue;
      }
      else if(pointer!=i)
      {
        putValue(vis1,n,0);
        for(int j=0;newKey[i][j]!='\0';j++)
        {
          vis1[newKey[i][j]-'a']=1;
        }
        int flag=0;
        for(int j=0;j<n;j++)
        {
          if(vis[j]==1)
          {
            if(vis1[j]==1)
            {
              continue;
            }
            if(vis1[j]==0)
            {
              flag=1;
              break;
            }
          }
        }
        if(flag==0)
        {
          for(int j=0;j<100;j++)
          {
              newKey[i][j]='\0';
          }
        }
      }
    }
  }
  int findingKeys(char subset[][],int power,int vis[],int n,char newKey[][],char minimal[][],int count)
  {
    int size=0;
    int flag=0;
    int noOfKeys=0;
    int jkl=0;
    for(int i=0;i<n;i++)
    {
      if(vis[i]==1)
      {
        size++;
      }
    }
    jkl=size;
    for(int i=0;i<power;i++)
    {
      flag=0;
      if(subset[i][0]!='\0')
      {
        int check=checkSubsitute(newKey,noOfKeys,subset,power,i);
        if(check==-1)
        {
          System.out.println("giberish");
          continue;
        }
        //System.out.println("it is good thing");
        notOnRhs(vis,n,minimal,count);
        essentialAttributes(newKey,vis,n);
        for(int j=0;subset[i][j]!='\0';j++)
        {
          vis[subset[i][j]-'a']=1;//here change with'A'
        }
        calculateClosure(vis,n,minimal,count);
        for(int j=0;j<n;j++)
        {
          if(vis[j]==0)
          {
            flag=1;
            break;
          }
        }
        if(flag==0)
        {
          jkl=size;
          //System.out.println("key is found here");
          for(int j=0;subset[i][j]!='\0';j++)
          {
            newKey[noOfKeys][jkl++]=subset[i][j];
          }
          noOfKeys++;
        }
      }
    }
    if(noOfKeys==0)
    {
      return noOfKeys+1;
    }
    else if(noOfKeys!=0)
    {
      return noOfKeys;
    }
    return noOfKeys;
  }
  int checkSubsitute(char newKey[][],int noOfKeys,char subset[][],int power,int pointer)
  {
    char[] temp=new char[100];
    char[] temp1=new char [100];
    for(int i=0;i<100;i++)
    {
      temp[i]='\0';
      temp1[i]='\0';
    }
    for(int i=0;subset[pointer][i]!='\0';i++)
    {
      temp[i]=subset[pointer][i];
    }
    descOrder(temp);
    String str=new String(temp);
    //System.out.println(pointer+str);
    for(int i=0;i<noOfKeys;i++)
    {
      for(int j=0;j<100;j++)
      {
        temp1[j]='\0';
      }
      for(int j=0;newKey[i][j]!='\0';j++)
      {
        temp1[j]=newKey[i][j];
      }
      descOrder(temp1);
      String str1=new String (temp1);
      int check=isSubstring(str,str1);
      if(check!=-1)
      {
        return -1;
      }
    }
    return 0;
  }
  void descOrder(char[] s)
  {
      Arrays.sort(s);
      reverse(s);
  }

  void reverse(char[] a)
  {
      int i, n = a.length;
      char t;
      for (i = 0; i < n / 2; i++)
      {
          t = a[i];
          a[i] = a[n - i - 1];
          a[n - i - 1] = t;
      }
  }
  int isSubstring(String s1, String s2)
  {
    int M=calculateLength(s1);
    int N =calculateLength(s2);
    for (int i = 0; i <= N - M; i++) {
        int j;

        /* For current index i, check for pattern match */
        for (j = 0; j < M; j++)
            if (s2.charAt(i+j) != s1.charAt(j))
                break;

        if (j == M)
            return i;
    }

    return -1;
  }
  int calculateLength(String s)
  {
    for(int i=0;i<100;i++)
    {
      if(s.charAt(i)=='\0')
      {
          return i;
      }
    }
    return 0;
  }
  void essentialAttributes(char newKey[][],int vis[],int n)
  {
    int pointer=0;
    for(int i=0;i<100;i++)
    {
      pointer=0;
      for(int j=0;j<n;j++)
      {
        if(vis[j]==1)
        {
          newKey[i][pointer++]=(char)(j+'a');//here change with A
        }
      }
    }
  }
  void calculateSubset(char set[],int size,char subset[][],int power)
  {
    int n=size;
    int counter=0;
    int pointer=0;
    for (int i = 0; i < (1<<n); i++)
    {
      pointer=0;
      for (int j = 0; j < n; j++)
      {
        if ((i & (1 << j)) > 0)
        {
          subset[counter][pointer++]=set[j];
        }
      }
      counter++;
    }
  }
  int calculatePower(int size)
  {
    int p=1;
    for(int i=1;i<=size;i++)
    {
      p=p*2;
    }
    return p;
  }
  void findAttributes(int vis2[],int vis1[],int vis[],int n)
  {
    for(int i=0;i<n;i++)
    {
      vis2[i]=vis2[i]-vis1[i]-vis[i];
    }
  }
  void calculateClosure(int vis[],int n,char minimal[][],int count)
  {
    int pointer=0;
    int flag=0;
      for(int i=0;i<count;i++)
      {
        for(int k=0;k<2;k++)
        {
          for(int j=0;j<count;j++)
          {
            pointer=0;
            flag=0;
            if(i==j)
            {
              continue;
            }
            else if (i!=j)
            {
              for(int l=0;minimal[j][l]!='-';l++)
              {
                if(vis[minimal[j][l]-'a']==0) // change with A
                {
                  flag=1;
                  break;
                }
              }// for vis
              if(flag==0)
              {
                for(int l=0;;l++)
                {
                  if(minimal[j][l]=='>')
                  {
                    pointer=l;
                    break;
                  }
                }
                pointer++;
                vis[minimal[j][pointer]-'a']=1;//change with A
              }
            }
          }
        }
      }
  }
  void onRhsNotOnLhs(int vis1[],int n,char minimal[][],int count)
  {
    putValue(vis1,n,1);
    notOnRhs(vis1,n,minimal,count);
    for(int i=0;i<n;i++)
    {
      if(vis1[i]==0)
      {
        vis1[i]=1;
      }
      else if(vis1[i]==1)
      {
        vis1[i]=0;
      }
    }
    int [] vis2=new int [n];
    putValue(vis2,n,0);
    OnLhs(vis2,n,minimal,count);
    int [] vis3=new int[n];
    putValue(vis3,n,0);
    for(int i=0;i<n;i++)
    {
      if(vis1[i]==1&&vis2[i]==0)
      {
        vis3[i]=1;
      }
    }
    for(int i=0;i<n;i++)
    {
      vis1[i]=vis3[i];
    }
  }
  void OnLhs(int vis[],int n,char minimal[][],int count)
  {
    for(int i=0;i<count;i++)
    {
      for(int j=0;minimal[i][j]!='-';j++)
      {
        vis[minimal[i][j]-'a']=1;//change with A
      }
    }
  }
  void notOnRhs(int vis[],int n,char minimal[][],int count)
  {
    int pointer=0;
    for(int i=0;i<count;i++)
    {
      pointer=0;
      for(int j=0;;j++)
      {
        if(minimal[i][j]=='>')
        {
          pointer=j;
          break;
        }
      }
      pointer++;
      for(int j=pointer;minimal[i][j]!='\0';j++)
      {

        vis[minimal[i][j]-'a']=0;//change here with A
      }
    }
  }
  void putValue(int vis[],int n,int flag)
  {
    for(int i=0;i<n;i++)
    {
      vis[i]=flag;
    }
  }
}
class CalculateMinimal
{
  char[][] newDependencies=new char[100][100];
  char [][] finalDependencies=new char [100][100];
  int calculateMinimal(char dependencies[][],int m,int n,char minimal[][])
  {
    clear(newDependencies,100,100);
    clear(finalDependencies,100,100);
    clear(minimal,100,100);
    int count1=seprate(dependencies,m,newDependencies);
    int tempCounter=deleteNullDependency(newDependencies,count1);
    char [][] temp=new char [tempCounter][100];
    clear(temp,tempCounter,100);
    swap(newDependencies,count1,temp,tempCounter);
    count1=tempCounter;
    int counter=calculateEssential(newDependencies,count1,n);
    clear(finalDependencies,count1-counter,100);
    int up=checkLeftside(newDependencies,count1,finalDependencies,count1-counter,n);
    for(int i=0;i<up;i++)
    {
      for(int j=0;finalDependencies[i][j]!='\0';j++)
      {
        minimal[i][j]=finalDependencies[i][j];
      }
    }
    /*for(int i=0;i<up;i++)
    {
      System.out.println(finalDependencies[i]);
    }*/
    return up;
    /*for(int i=0;i<up;i++)
    {
      System.out.println(finalDependencies[i]);
    }*/
  }
  void swap(char newDependencies[][],int count1,char temp[][],int tempCounter)
  {
    int count=0;
    for(int i=0;i<count1;i++)
    {
      if(newDependencies[i][0]=='\0')
      {
        continue;
      }
      else if(newDependencies[i][0]!='\0')
      {
        for(int j=0;newDependencies[i][j]!='\0';j++)
        {
          temp[count][j]=newDependencies[i][j];
        }
        count++;
      }
    }
    /*for(int i=0;i<count;i++)
    {
      System.out.println(temp[i]);
    }*/
    clear(newDependencies,100,100);
    for(int i=0;i<tempCounter;i++)
    {
      for(int j=0;temp[i][j]!='\0';j++)
      {
        newDependencies[i][j]=temp[i][j];
      }
    }
  }
  int deleteNullDependency(char newDependencies[][],int count1)
  {
    int count=count1;
    for(int i=0;i<count1;i++)
    {
      if(newDependencies[i][1]=='-')
      {
        if(newDependencies[i][0]==newDependencies[i][3])
        {
          newDependencies[i][0]='\0';
          newDependencies[i][1]='\0';
          newDependencies[i][2]='\0';
          newDependencies[i][3]='\0';
          count--;
        }
      }
    }
    return count;
  }
  int checkLeftside(char newDependencies[][],int count1,char finalDependencies[][],int counter,int n)
  {
    int [] vis=new int[n];
    int [] vis1=new int[n];
    int count=0;
    int pointer=0;
    int pointer1=0;
    int flag=0;
    for(int i=0;i<count1;i++)
    {
      flag=0;
      pointer=0;
      pointer1=0;
      clearint(vis,n);
      clearint(vis1,n);
      if(newDependencies[i][0]=='\0')
      {
        continue;
      }
      if(newDependencies[i][1]=='-')
      {
        for(int j=0;newDependencies[i][j]!='\0';j++)
        {
          finalDependencies[count][j]=newDependencies[i][j];
        }
        count++;
      }
      else
      {
        int initialCount=count;
        for(int j=0;newDependencies[i][j]!='\0';j++)
        {
          if(newDependencies[i][j]!='-'&&newDependencies[i][j]!='>')
          {
            vis[newDependencies[i][j]-'a']=1;//here change with A
          }
        }
        for(int k=0;k<2;k++)
        {
          for(int j=0;j<count;j++)
          {
            pointer=0;
            flag=0;
            if(i==j||newDependencies[j][0]=='\0')
            {
              continue;
            }
            else if (i!=j)
            {
              for(int l=0;newDependencies[j][l]!='-';l++)
              {
                if(vis[newDependencies[j][l]-'a']==0) // change with A
                {
                  flag=1;
                  break;
                }
              }// for vis
              if(flag==0)
              {
                for(int l=0;;l++)
                {
                  if(newDependencies[j][l]=='>')
                  {
                    pointer=l;
                    break;
                  }
                }
                pointer++;
                vis[newDependencies[j][pointer]-'a']=1;//change with A
              }
            }
          }
        }// till here calculating the complete closure of the given fd
        int size=0;
        for(int j=0;newDependencies[i][j]!='-';j++)
        {
            size++;
        }
        //System.out.println(size);
        char [] set=new char [size];
        for(int j=0;newDependencies[i][j]!='-';j++)
        {
          set[j]=newDependencies[i][j];
        }
        CalculateNewKey cnk=new CalculateNewKey();
        int power=cnk.calculatePower(size);
        char [][] subset=new char[power][100];
        clear(subset,power,100);
        cnk.calculateSubset(set,size,subset,power);
        /*for(int q=0;q<power;q++)
        {
          System.out.println(subset[q]);
        }*/
        //System.out.println("END");
        int [] vis5=new int[n];
        int [] vis6=new int[n];
        for(int jl=1;jl<power-1;jl++)
        {
          clearint(vis5,n);
          clearint(vis6,n);
          clearint(vis1,n);
          for(int kl=0;subset[jl][kl]!='\0';kl++)
          {
              vis1[subset[jl][kl]-'a']=1;//change with A
          }
          for(int kl=0;kl<size;kl++)
          {
            vis5[set[kl]-'a']=1;
          }
          for(int kl=0;kl<n;kl++)
          {
            vis6[kl]=vis5[kl]-vis1[kl];
          }
          /*System.out.print("The value of vis5 is ");
          for(int ij=0;ij<n;ij++)
          {
            System.out.print(vis5[ij]+" ");
          }
          System.out.println();

          System.out.print("The value of vis1 is ");
          for(int ij=0;ij<n;ij++)
          {
            System.out.print(vis1[ij]+" ");
          }
          System.out.println();

          System.out.print("The value of vis6 is ");
          for(int ij=0;ij<n;ij++)
          {
            System.out.print(vis6[ij]+" ");
          }
          System.out.println();*/

          for(int k=0;k<2;k++)
          {
            for(int j=0;j<count;j++)
            {
              pointer=0;
              flag=0;
              if(i==j||newDependencies[j][0]=='\0')
              {
                continue;
              }
              else if (i!=j)
              {
                for(int l=0;newDependencies[j][l]!='-';l++)
                {
                  if(vis1[newDependencies[j][l]-'a']==0) // change with A
                  {
                    flag=1;
                    break;
                  }
                }// for vis1
                if(flag==0)
                {
                  for(int l=0;;l++)
                  {
                    if(newDependencies[j][l]=='>')
                    {
                      pointer=l;
                      break;
                    }
                  }
                  pointer++;
                  vis1[newDependencies[j][pointer]-'a']=1;//change with A
                }
              }
            }
          }
          int flag1=0;
          for(int j=0;j<n;j++)
          {
            if(vis6[j]==1)
            {
              if(vis1[j]==1)
              {
                continue;
              }
              else if(vis1[j]==0)
              {
                flag1=1;
                break;
              }
            }
          }
          if(flag1==0)
          {

            int x=0;
            for(int jklm=0;subset[jl][jklm]!='\0';jklm++)
            {
              finalDependencies[count][x++]=subset[jl][jklm];
            }
            finalDependencies[count][x++]='-';
            finalDependencies[count][x++]='>';
            int pointer2=0;
            for(int jklm=0;;jklm++)
            {
              if(newDependencies[i][jklm]=='>')
              {
                pointer2=jklm;
                break;
              }
            }
            pointer2++;
            for(int j=pointer2;newDependencies[i][j]!='\0';j++)
            {
              finalDependencies[count][x++]=newDependencies[i][j];
            }
            count++;
          }
          clearint(vis1,n);
          clearint(vis5,n);
          clearint(vis6,n);
          //break;
        }
        if(initialCount==count)
        {
          for(int jkl=0;newDependencies[i][jkl]!='\0';jkl++)
          {
            finalDependencies[count][jkl]=newDependencies[i][jkl];
          }
          count++;
        }
      }
    }
    return count;
  }
  int calculateEssential(char newDependencies[][],int count,int n)
  {
    int [] vis=new int [n];
    int [] vis1=new int[n];
    int pointer=0;
    int flag=0;
    int counter=0;
    for(int i=0;i<count;i++)
    {
      clearint(vis,n);
      clearint(vis1,n);
      for(int j=0;newDependencies[i][j]!='\0';j++)
      {
        if(newDependencies[i][j]!='-'&&newDependencies[i][j]!='>')
        {
          vis[newDependencies[i][j]-'a']=1;//here change with A
        }
      }// taking for the attributes for closure with that dependencies
      for(int j=0;newDependencies[i][j]!='-';j++)
      {
        vis1[newDependencies[i][j]-'a']=1;
      }// taking for the attributes without that dependency;
      for(int k=0;k<2;k++)
      {
        for(int j=0;j<count;j++)
        {
          pointer=0;
          flag=0;
          if(i==j||newDependencies[j][0]=='\0')
          {
            continue;
          }
          else if (i!=j)
          {
            for(int l=0;newDependencies[j][l]!='-';l++)
            {
              if(vis[newDependencies[j][l]-'a']==0) // change with A
              {
                flag=1;
                break;
              }
            }// for vis
            if(flag==0)
            {
              for(int l=0;;l++)
              {
                if(newDependencies[j][l]=='>')
                {
                  pointer=l;
                  break;
                }
              }
              pointer++;
              vis[newDependencies[j][pointer]-'a']=1;//change with A
            }
          }
        }
      }
      //System.out.print("this is vis array ");
      /*for(int j=0;j<n;j++)
      {
        System.out.print(vis[j]+" ");
      }*/
      //System.out.println();
      for(int k=0;k<2;k++)
      {
        for(int j=0;j<count;j++)
        {
          pointer=0;
          flag=0;
          if(i==j||newDependencies[j][0]=='\0')
          {
            continue;
          }
          else if (i!=j)
          {
            for(int l=0;newDependencies[j][l]!='-';l++)
            {
              if(vis1[newDependencies[j][l]-'a']==0) // change with A
              {
                flag=1;
                break;
              }
            }// for vis1
            if(flag==0)
            {
              for(int l=0;;l++)
              {
                if(newDependencies[j][l]=='>')
                {
                  pointer=l;
                  break;
                }
              }
              pointer++;
              vis1[newDependencies[j][pointer]-'a']=1;//change with A
            }
          }
        }
      }
      //System.out.print("this is vis1 array ");
      /*for(int j=0;j<n;j++)
      {
        System.out.print(vis1[j]+" ");
      }*/
      //System.out.println();
      int flag1=0;
      for(int j=0;j<n;j++)
      {
        if(vis[j]!=vis1[j])
        {
          flag1=1;
          break;
        }
      }
      if(flag1==0)
      {
        counter++;
        for(int j=0;newDependencies[i][j]!='\0';j++)
        {
          newDependencies[i][j]='\0';
        }
      }
    }
    return counter;

  }
  int seprate(char dependencies[][],int m,char newDependencies[][])
  {
    int pointer=0;
    int count=0;
    for(int i=0;i<m;i++)
    {
      pointer=0;
      for(int j=0;;j++)
      {
        if(dependencies[i][j]=='>')
        {
          pointer=j;
          break;
        }
      }
      pointer++;
      for(int j=pointer;dependencies[i][j]!='\0';j++)
      {
        for(int l=0;l<pointer;l++)
        {
          newDependencies[count][l]=dependencies[i][l];
        }
        newDependencies[count++][pointer]=dependencies[i][j];
      }
    }
    return count;
  }
  void clearint(int vis[],int n)
  {
    for(int i=0;i<n;i++)
    {
      vis[i]=0;
    }
  }
  void clear(char newDependencies[][],int m,int n)
  {
    for(int i=0;i<m;i++)
    {
      for(int j=0;j<n;j++)
      {
        newDependencies[i][j]='\0';
      }
    }
  }
}
class Closere
{
    int flag=0;
    int k=0;
    int pointer=0;
    Closere()
    {

    }
    void calculateClosure(char dependencies[][],char closure[][],int n,int m)
    {
      for(int jkl=0;jkl<2;jkl++)
      {
        for(int i=0;i<m;i++)
        {
          pointer=0;
          for(int j=0;dependencies[i][j]!='\0';j++)
          {
            flag=0;
            if(dependencies[i][j]!='-'&&dependencies[i][j]!='>')
            {
              for(int l=0;closure[i][l]!='\0';l++)
              {
                if(closure[i][l]==dependencies[i][j])
                {
                    flag=1;
                    break;
                }
              }
              if(flag==0)
              {
                  closure[i][pointer++]=dependencies[i][j];
              }
            }
          }
        }
        for(int i=0;i<m;i++)
        {
          for(int j=0;j<m;j++)
          {
            flag=0;
            k=0;
            if(i==j)
            {
              continue;
            }
            else if(i!=j)
            {
              while(dependencies[j][k]!='-')
              {
                for(int l=0;closure[i][l]!='\0';l++)
                {
                  if(closure[i][l]==dependencies[j][k])
                  {
                    flag=flag+1;
                    break;
                  }
                }
                k++;
              }
              if(flag==k)
              {
                pointer=0;
                flag=0;
                for(int l=0;;l++)
                {
                  if(dependencies[j][l]=='>')
                  {
                    pointer=l;
                    break;
                  }
                }
                pointer++;
                for(int l=pointer;dependencies[j][l]!='\0';l++)
                {
                  for(int p=0;closure[i][p]!='\0';p++)
                  {
                    flag=0;
                    if(dependencies[j][l]==closure[i][p])
                    {
                      flag=1;
                      break;
                    }
                  }
                  if(flag==0)
                  {
                    for(int p=0;closure[i][p]!='\0';p++)
                    {
                      pointer=p;
                    }
                    closure[i][++pointer]=dependencies[j][l];
                  }
                }
              }
            }
          }
        }
      }
      }
}
