async function fetchData(url, setData) {
	try {
		const response = await fetch(url);
		const data = await response.json();
		const details = JSON.parse(data.contents);
		setData(details);
	} catch (error) {
		console.log(error);
	}
}

export default fetchData;
