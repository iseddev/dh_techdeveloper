async function fetchGames(url, setData) {
	try {
		const response = await fetch(url);
		const data = await response.json();
		const games = JSON.parse(data.contents);
		setData(games);
	} catch (error) {
		console.log(error);
	}
}

export default fetchGames;
