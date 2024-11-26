const regex_name_lastName = /^[a-zA-Z]+$/;
const regex_address = /^[a-zA-Z0-9\s]+$/;
const regex_email = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
const regex_phone = /^[0-9]{7,14}$/;

export const isValidName = (name) =>
	name.trim().length > 2 && regex_name_lastName.test(name.trim());

export const isValidLastName = (lastName) =>
	lastName.trim().length > 2 && regex_name_lastName.test(lastName.trim());

export const isValidAddress = (address) =>
	address.trim().length > 9 && regex_address.test(address.trim());

export const isValidEmail = (email) => regex_email.test(email.trim());

export const isValidPhone = (phone) => regex_phone.test(phone.trim());
