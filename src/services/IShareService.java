package services;

import model.Share;

public interface IShareService {
	Iterable<Share> listAllShare();

    Share saveShare(Share share);
    
    Share findShareByCode(String code);

    void deleteShare(Integer id);

	void deleteShareByCode(String code);
}
