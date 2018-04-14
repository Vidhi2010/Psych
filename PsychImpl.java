import java.rmi.*;
import java.util.*;
import java.math.*;
public class PsychImpl extends java.rmi.server.UnicastRemoteObject implements Psychintf
{
	static String answers[] = new String[3];
	static String name[] = new String[3];
	static String allAns = "";
	static int ans=0;
	static int nm=0,j1=0,i1=0,i=0;
	static int selected[] = new int[3];
	static String quest[]={",hello?",",hello1?",",hello2?"};
	public PsychImpl() throws RemoteException
	{
		super();
	}

	public String sendQuestion() throws RemoteException
	{

		if(i1==0)
		{i= (int)(Math.random()*3);
		i1++;
		while(quest[i].equals("0")){
			i=(i+1)%3;
		}
	    }
		String Q=quest[i];
		if(i1==3)
		{quest[i]="0";
	     i1=0;}   
		return Q;

	}
	public int getAnswers(String a,String b) throws RemoteException
	{
		answers[ans]=a;
		allAns = allAns +"\n"+ans+"."+a;
		name[ans]=b;
		ans++;
		return (ans-1);
	}
	public String sendAnswers() throws RemoteException
	{
		if(ans<3){return "0";}
		return allAns;
	}
	public void getIndex(int i) throws RemoteException
	{
		selected[i]++;
		j1++;
	}
	public String sendResult() throws RemoteException
	 {
	 	if(j1<3){return "0";}
	 	int max=0,j=0;
	 	for (int i=0;i<3 ;i++ ) {
	 		if(max<selected[i])
	 		{
	 			max=selected[i];
	 			j=i;
	 		}

	 	}
	 	String winner="winner is "+name[j]+"with answer:"+answers[j];
	 	return winner;
	}
}