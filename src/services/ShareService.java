package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import model.Share;
import repositories.ShareRepo;

@Service
public class ShareService implements IShareService{
	
	private ShareRepo shareRepo;
	
	public ShareRepo getShareRepo() {
		return shareRepo;
	}

	@Autowired
	public void setShareRepo(ShareRepo shareRepo) {
		this.shareRepo = shareRepo;
	}

	@Override
	public Iterable<Share> listAllShare() {
		Iterable<Share> shareList= shareRepo.findAll();
		return shareList;
	}

	@Override
	public Share saveShare(Share share) {
		return shareRepo.save(share);
	}

	@Override
	public void deleteShare(Integer id) {
		shareRepo.deleteById(id);
	}
	
	@Override
	public void deleteShareByCode(String code) {
		shareRepo.deleteShareByCode(code);
	}

	@Override
	public Share findShareByCode(@Param("code") String code) {
		Share share = shareRepo.findShareByCode(code);
		return share;
	}


}
