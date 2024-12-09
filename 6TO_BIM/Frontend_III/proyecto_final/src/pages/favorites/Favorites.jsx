import Layout from "../../components/layout/Layout";

const Favorites = ({ favorites }) => {
	return (
		<Layout>
			<main>
				<h2>Favoritos</h2>
				<p>En esta sección se mostrarán los personajes favoritos.</p>
				{/* Logic to add favorites characters */}
				{favorites.length === 0 ? (
					<p>No personajes favoritos.</p>
				) : (
					<ul>
						{favorites.map((favorite) => (
							<li key={favorite.id}>{favorite.name}</li>
						))}
					</ul>
				)}
			</main>
		</Layout>
	);
};

export default Favorites;
