export const getComments = async () => {
	const endPoint = "https://jsonplaceholder.typicode.com/comments";

	try {
		const response = await fetch(endPoint);
		const data = await response.json();
		return data;
	} catch (error) {
		console.error("Fetch Error", error);
	}
};
