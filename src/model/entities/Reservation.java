package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {

	private Integer roomNumber;
	private Date checkin;
	private Date checkout;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation() {
	}

	public Reservation(Integer roomNumber, Date checkin, Date checkout) {
		if (!checkout.after(checkin)) {
			throw new DomainException("Checkout date must be after checkin date.");
		}
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public long duration() {
		long diff = checkout.getTime() - checkin.getTime(); // valor traz resultado em milissegundos.
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); // converte a diferença de milissegundos para dias.
	}

	public void updateDates(Date checkin, Date checkout) {
		Date now = new Date();
		if (checkin.before(now) || checkout.before(now)) {
			// chamada de uma exceção de quando os argumentos que são passados para o método
			// são inválidos. exceção fornecida pelo java.
			throw new DomainException("Reservation dates for update must be future dates.");
		}
		if (!checkout.after(checkin)) {

			throw new DomainException("Checkout date must be after checkin date.");
		}
		this.checkin = checkin;
		this.checkout = checkout;
	}

	@Override
	public String toString() {
		return "Room " + roomNumber + ", check-in: " + sdf.format(checkin) + ", checkout: " + sdf.format(checkout)
				+ ", " + duration() + " nights.";
	}
}
