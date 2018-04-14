import java.rmi.Naming;
import java.util.*;
import java.io.*;
public class PsychClient {

    public static void main(String[] args) {
 try { 
 	Scanner sc=new Scanner(System.in);
Psychintf c = (Psychintf)Naming.lookup("rmi://localhost//PsychService");
System.out.println("enter ur name\n");
String name=sc.next();
System.out.println(c.sendQuestion());
System.out.println("Answer:\n");
 String answer=sc.next();
 int index=c.getAnswers(answer,name);
 String Answer=c.sendAnswers();
 while(Answer.equals("0"))
{
Answer=c.sendAnswers();
}
 System.out.println(Answer);
 System.out.println("Select index of answer you like bt not your own\n");
 int in=sc.nextInt();
 while(index==in)
 {
 	System.out.println("can't select your own answer\n");
 	in=sc.nextInt();
 }
c.getIndex(in);
String winner;
winner=c.sendResult();
while(winner.equals("0"))
{
winner=c.sendResult();
}
 System.out.println(winner);
 }
 catch (Exception e) {
 System.out.println(e);
 }
 }
}