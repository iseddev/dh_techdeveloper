const StatusTripulante = ({ tripulantes }) => {
	const listaTripulantes = tripulantes.map((tripulante, index) => (
		// const listaTripulantes = tripulantes.map((tripulante) => (
		// We will get an error if we don't use a key prop
		// <li>
		// 	{tripulante.nombre} {tripulante.esImpostor ? "es impostor" : "no es impostor"}
		// </li>
		// We can fix it by adding a key prop. We can use the index as a key, but it's not recommended, instead we should use a unique identifier
		<li key={index}>
			{tripulante.nombre} {tripulante.esImpostor ? "es impostor" : "no es impostor"}
		</li>
	));
	return <ul>{listaTripulantes}</ul>;
};

export default StatusTripulante;
