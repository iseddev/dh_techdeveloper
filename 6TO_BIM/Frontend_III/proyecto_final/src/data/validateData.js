const emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
const nameRegex = /^[a-zA-ZÀ-ÿ\s]+$/;

const isValidText = (text) => {
	const trimmedText = text.trim();
	const textAsArray = trimmedText.split("");
	const isValidUserName = textAsArray.every((char) => nameRegex.test(char));
	return trimmedText.length > 2 && isValidUserName;
};

const isValidEmail = (email) => emailRegex.test(email);

export { isValidText, isValidEmail };
