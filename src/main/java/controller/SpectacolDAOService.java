package controller;

import java.util.ArrayList;
import model.Spectacol;

public interface SpectacolDAOService {

	public boolean addSpectacol(Spectacol spectacol);

	public void deleteSpectacol(int spectacolId);

	public ArrayList<Spectacol> getAllSpectacol();

	public boolean updateSpectacol(Spectacol spectacol);

}
