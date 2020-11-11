package com.codelabs.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import com.codelabs.exception.EntityNotFoundException;
import com.codelabs.model.Address;
import com.codelabs.model.Phone;
import com.codelabs.model.User;
import com.codelabs.repository.IUserRepository;
import com.codelabs.request.BasicDetails;
import com.codelabs.request.CreateUserRequest;
import com.codelabs.request.UserAddress;
import com.codelabs.request.UserPhone;
import com.codelabs.response.CreateSuccessResponse;
import com.codelabs.response.Response;
import com.codelabs.response.UserSuccessResponse;
import com.codelabs.service.IUserService;
import com.codelabs.utility.ErrorConstants;
import com.codelabs.utility.ErrorUtil;

@Service
public class UserService implements IUserService {
	
	@Autowired
	IUserRepository userRepo;
	
	@Autowired
	HttpHeaders httpHeaders;
	
	@Autowired
	ErrorUtil errorUtil;
	
	@Override
	public ResponseEntity<Response> getUser(Long userId) {
		com.codelabs.model.User dbuser = userRepo.findById(userId).get();
		if(ObjectUtils.isEmpty(dbuser)) {
			throw new EntityNotFoundException(ErrorConstants.NOT_FOUND);
		}
		com.codelabs.request.User user = new com.codelabs.request.User();
		setBasicInfo(user,dbuser);
		setAddressDetail(user,dbuser.getAddresses());
		setPhoneDetail(user, dbuser.getPhones());
		List<com.codelabs.request.User> userList = new ArrayList<>();
		userList.add(user);
		Response response = new Response();
		response.setUsers(userList);
		return new ResponseEntity<>(response,httpHeaders,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<CreateSuccessResponse> createUser(CreateUserRequest createUserRequest) {
		List<com.codelabs.model.User> users = setUserToSave(createUserRequest.getUsers());
		CreateSuccessResponse response = new CreateSuccessResponse();
		List<com.codelabs.model.User> savedUsers = userRepo.saveAll(users);
		if(CollectionUtils.isEmpty(savedUsers)) {
			response.setErrors(errorUtil.getErrorList(ErrorConstants.INSERT_FAILED));
			return new ResponseEntity<>(response,httpHeaders,HttpStatus.BAD_REQUEST);
		}else {
			List<UserSuccessResponse> success = new ArrayList<>();
			for(com.codelabs.model.User user: savedUsers) {
				UserSuccessResponse userSuccess = new UserSuccessResponse();
				userSuccess.setId(String.valueOf(user.getId()));
				userSuccess.setMessage("User With Name :- " + user.getFirstName() + " is craeted!");
				success.add(userSuccess);
			}
			response.setSuccess(success);
		}
		return new ResponseEntity<>(response,httpHeaders,HttpStatus.OK);
	}

	private List<com.codelabs.model.User> setUserToSave(List<com.codelabs.request.User> users) {
		List<com.codelabs.model.User> persistUsersList = new ArrayList<>();
		for(com.codelabs.request.User requestUser : users) {
			com.codelabs.model.User user = new com.codelabs.model.User();
			setBasicDetails(user, requestUser.getBasicInfo());
			setAddressDetail(user,requestUser.getAddresses());
			setPhoneDetail(user,requestUser.getPhones());
			persistUsersList.add(user);
		}
		return persistUsersList;
	}

	private void setPhoneDetail(com.codelabs.model.User user, List<UserPhone> phones) {	
		List<Phone> phoneList = new ArrayList<>();
		for(UserPhone phone :phones) {
			Phone userPhone = new Phone();
			userPhone.setKey(phone.getKey());
			userPhone.setNumber(phone.getNumber());
			userPhone.setPrimary(phone.isPrimary());
			userPhone.setType(phone.getType());
			phoneList.add(userPhone);
		}
		user.setPhones(phoneList);
	}
	
	private void setPhoneDetail(com.codelabs.request.User user, List<Phone> phones) {	
		List<UserPhone> phoneList = new ArrayList<>();
		for(Phone phone :phones) {
			UserPhone userPhone = new UserPhone();
			userPhone.setKey(phone.getKey());
			userPhone.setNumber(phone.getNumber());
			userPhone.setPrimary(phone.isPrimary());
			userPhone.setType(phone.getType());
			phoneList.add(userPhone);
		}
		user.setPhones(phoneList);
	}

	private void setAddressDetail(com.codelabs.request.User user, List<Address> addresses) {
		List<UserAddress> userAddressList = new ArrayList<>();
		for(Address address: addresses) {
			UserAddress userAddress = new UserAddress();
			userAddress.setId(address.getId());
			userAddress.setAddressLine1(address.getAddressLine1());
			userAddress.setAddressLine2(userAddress.getAddressLine2());
			userAddress.setCity(address.getCity());
			userAddress.setState(address.getState());
			userAddress.setType(address.getType());
			userAddress.setZipCode(address.getZipCode());
			userAddressList.add(userAddress);
		}
		user.setAddresses(userAddressList);
	}
	
	private void setAddressDetail(User user, List<UserAddress> addresses) {
		List<Address> userAddressList = new ArrayList<>();
		for(UserAddress address: addresses) {
			Address userAddress = new Address();
			userAddress.setAddressLine1(address.getAddressLine1());
			userAddress.setAddressLine2(userAddress.getAddressLine2());
			userAddress.setCity(address.getCity());
			userAddress.setState(address.getState());
			userAddress.setType(address.getType());
			userAddress.setZipCode(address.getZipCode());
			userAddressList.add(userAddress);
		}
		user.setAddresses(userAddressList);
	}

	private void setBasicDetails(com.codelabs.model.User user, BasicDetails info) {
		user.setFirstName(info.getFirstName());
		user.setMiddleName(info.getMiddleName());
		user.setLastName(info.getLastName());
		user.setAge(info.getAge());
		user.setDob(info.getDob());
		user.setEmailAddress(info.getEmailAddress());
		user.setGender(info.getGender());
		user.setHobbies(info.getHobbies());
		user.setPreferedLanguage(info.getPreferedLanguage());
	}

	@Override
	public ResponseEntity<Response> getUsers() {
		Response response = new Response();
		List<com.codelabs.model.User> users = userRepo.findAll();
		if(CollectionUtils.isEmpty(users)) {
			throw new EntityNotFoundException(ErrorConstants.NOT_FOUND);
		}
		List<com.codelabs.request.User> userList = new ArrayList<>();
		for(com.codelabs.model.User dbuser: users) {
			com.codelabs.request.User user = new com.codelabs.request.User();
			setBasicInfo(user,dbuser);
			setAddressDetail(user, dbuser.getAddresses());
			setPhoneDetail(user, dbuser.getPhones());
			userList.add(user);
		}
		response.setUsers(userList);
		return new ResponseEntity<>(response,httpHeaders,HttpStatus.OK);
	}

	private void setBasicInfo(com.codelabs.request.User user, com.codelabs.model.User dbuser) {
		BasicDetails basicInfo = new BasicDetails();
		basicInfo.setId(String.valueOf(dbuser.getId()));
		basicInfo.setFirstName(dbuser.getFirstName());
		basicInfo.setMiddleName(dbuser.getMiddleName());
		basicInfo.setLastName(dbuser.getLastName());
		basicInfo.setDob(dbuser.getDob());
		basicInfo.setAge(dbuser.getAge());
		basicInfo.setHobbies(dbuser.getHobbies());
		basicInfo.setEmailAddress(dbuser.getEmailAddress());
		basicInfo.setGender(dbuser.getGender());
		basicInfo.setPreferedLanguage(dbuser.getPreferedLanguage());
		user.setBasicInfo(basicInfo);
	}

}
