package application;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import Model.Exception.DomainException;

public class Reserva {

	private Integer number;
	private Date check_in;
	private Date check_out;
	
	@SuppressWarnings("unused")
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva() {
		
	}

	public Reserva(Integer number, Date check_in, Date check_out) {
		this.number=number;
		this.check_in=check_in;
		this.check_out=check_out;
	}

	public Date getCheck_in() {
		return check_in;
	}

	public Date getCheck_out() {
		return check_out;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
	
	public long duration() {
		long diff = check_out.getTime() - check_in.getTime();
		return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
	}
	
	public void update(Date check_in, Date check_out) throws DomainException{
		Date now = new Date();
		if (check_in.before(now) || check_out.before(now)) {
			throw new DomainException("Data não condiz com tempo certo");
		}
		if (!check_out.after(check_in)) {
			throw new DomainException("Data de check_out deve estar depois do check_in");
		}
		this.check_in=check_in;
		this.check_out = check_out;
	}
}
