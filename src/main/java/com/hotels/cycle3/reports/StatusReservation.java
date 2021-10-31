package com.hotels.cycle3.reports;

/**
 * @author MARIO
 *
 */
public class StatusReservation {

	private int completed;
	private int cancelled;

	public StatusReservation(int completed, int cancelled) {
		this.completed = completed;
		this.cancelled = cancelled;
	}

	/**
	 * @return the completed
	 */
	public int getCompleted() {
		return completed;
	}

	/**
	 * @param completed the completed to set
	 */
	public void setCompleted(int completed) {
		this.completed = completed;
	}

	/**
	 * @return the cancelled
	 */
	public int getCancelled() {
		return cancelled;
	}

	/**
	 * @param cancelled the cancelled to set
	 */
	public void setCancelled(int cancelled) {
		this.cancelled = cancelled;
	}

}
