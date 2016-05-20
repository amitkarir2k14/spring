package app.repository;

import app.pojos.Spitter;

public interface SpitterRepository {

	void save(Spitter spitter);
	Spitter getByUsername(String username);
	
}
