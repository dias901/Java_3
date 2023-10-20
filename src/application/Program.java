package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Model.Exception.DomainException;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc =new Scanner(System.in);
		
		System.out.println("Reserva hotel chique");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
		System.out.println("number");
		Integer number = sc.nextInt();
		System.out.println("check_in");
		Date dt1 = sdf.parse(sc.next());
		System.out.println("check_out");
		Date dt2 = sdf.parse(sc.next());
		Reserva res = new Reserva(number,dt1,dt2);
		System.out.println(res.getNumber());
		System.out.println(res.getCheck_in());
		System.out.println(res.getCheck_out());
		System.out.println(res.duration());
		res.update(dt1,dt2);
		}catch(ParseException e){
			//e.printStackTrace();
			System.out.println("data errada");
		}catch(DomainException e){
			System.out.println("erro na reserva");
		}
		
		System.out.println("deu fim");
		sc.close();
	}
}
