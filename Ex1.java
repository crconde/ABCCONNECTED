import java.util.Scanner;
public class Ex1
{
	public static void main (String[] args)
	{
		Scanner ler = new Scanner(System.in);
		System.out.print("Escreva um numero: ");
		double l1 = ler.nextDouble();
		Scanner ler1 = new Scanner(System.in);
		System.out.print("Escreva um numero: ");
		double l2 = ler1.nextDouble();
		Scanner ler2 = new Scanner(System.in);
		System.out.print("Escreva um numero: ");
		double l3 = ler2.nextDouble();
		double m= ((l1 + l2 + l3)/3);
		System.out.print("A media e " + m);
	}
}