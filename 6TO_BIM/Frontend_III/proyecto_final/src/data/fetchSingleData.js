async function fetchSingleData(url, setData) {
	try {
		const response = await fetch(url);
		const data = await response.json();
		setData(data);
	} catch (error) {
		console.log(error);
	}
}

export default fetchSingleData;
