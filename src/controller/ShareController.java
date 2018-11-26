package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import model.Share;
import services.IShareService;

@RestController
@RequestMapping("/share")
@OpenAPIDefinition(tags = {
})
public class ShareController {
	private IShareService shareServiceInterface;

	public IShareService getShareServiceInterface() {
		return shareServiceInterface;
	}

	@Autowired
	public void setShareServiceInterface(IShareService shareServiceInterface) {
		this.shareServiceInterface = shareServiceInterface;
	}
	
	@ApiOperation(value = "Edit Share")
    @RequestMapping(value = "/update/{code}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity updateShare(@PathVariable String code, @RequestBody Share share){
        Share shareModel = shareServiceInterface.findShareByCode(code);
        shareModel.setDate(share.getDate());
        shareModel.setCode(share.getCode());
        shareModel.setPrice(share.getPrice());
        
        shareServiceInterface.saveShare(shareModel);
        return new ResponseEntity("Share updated", HttpStatus.OK);
    }
	
	@ApiOperation(value = "Delete a share")
    @RequestMapping(value="/delete/{code}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity delete(@PathVariable String code){
        shareServiceInterface.deleteShareByCode(code);
        return new ResponseEntity("Share deleted", HttpStatus.OK);

    }
	
}
