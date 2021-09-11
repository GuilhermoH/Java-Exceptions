package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation() {
		super();
	}

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException {
		if (!checkOut.after(checkIn)) {
			throw new DomainException("CHECK OUT MUST BE AFTER CHECK IN");
		}
		
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		long diff = checkOut.getTime();
		long diff2 = checkIn.getTime();
		long result = diff - diff2;
		return TimeUnit.DAYS.convert(result, TimeUnit.MILLISECONDS);
	}

	public void updateDates(Date a, Date b) throws DomainException  {
		this.checkIn = a;
		this.checkOut = b;
		Date now = new Date();
		if (a.before(now) || b.before(now)) {
			throw new DomainException ("RESERVATION MUST BE IN FUTURE DAYS");
		}
		if (!b.after(a)) {
			throw new DomainException("CHECK OUT MUST BE AFTER CHECK IN");
		}
	}

	@Override
	public String toString() {
		return "Room: " + roomNumber + ", checkIn- " + sdf.format(checkIn) + ", checkOut-" + sdf.format(checkOut)
				+ ", duration: " + duration() + " nights";

	}

}
