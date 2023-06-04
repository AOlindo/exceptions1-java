package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DominioException;

public class Reserva {

	private Integer numeroDoQuarto;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");

	public Reserva() {

	}

	public Reserva(Integer numeroDoQuarto, Date checkIn, Date checkOut) throws DominioException {
		if (!checkOut.after(checkIn)) {
			throw new DominioException("Erro na reserva: a data de check-out deve ser posterior à data de check-in");
		}
		this.numeroDoQuarto = numeroDoQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumeroDoQuarto() {
		return numeroDoQuarto;
	}

	public void setNumeroDoQuarto(Integer numeroDoQuarto) {
		this.numeroDoQuarto = numeroDoQuarto;
	}

	public Date getCheckin() {
		return checkIn;
	}

	public Date getcheckOut() {
		return checkOut;
	}

	public long duracao() {
		long diferenca = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
	}

	public void atualizarData(Date checkIn, Date checkOut) throws DominioException {
		Date now = new Date();

		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DominioException("Erro na reserva: as datas da reserva para atualização devem ser datas futuras");
		}
		if (!checkOut.after(checkIn)) {
			throw new DominioException("Erro na reserva: a data de check-out deve ser posterior à data de check-in");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		return "Reserva: " + numeroDoQuarto + ", check-in: " + sdf.format(checkIn) + ", check-out: "
				+ sdf.format(checkOut) + ", " + duracao() + " noites";
	}

}
