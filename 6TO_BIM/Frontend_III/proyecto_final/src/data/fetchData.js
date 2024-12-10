const maxCharacters = 30;

async function fetchData(url, setData) {
	try {
		const response = await fetch(url);
		const data = await response.json();
		const items = data.items;
		setData(items);
	} catch (error) {
		console.log(error);
	}
}

export { fetchData, maxCharacters };
