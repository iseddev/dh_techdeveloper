import { useEffect, useState } from "react";

import DetallePedido from "./DetallePedido";

import "./App.css";

function App() {
	const [cancelado, setCancelado] = useState(true);
	const [mostrarDetalle, setMostrarDetalle] = useState(false);

	useEffect(() => {
		const timer = setTimeout(() => {
			if (mostrarDetalle) {
				setCancelado(false);
				console.log("Componente montado correctamente");
			}
		}, 2000);
		return () => clearTimeout(timer);
	}, [mostrarDetalle]);

	const handleButtonCancel = () => {
		alert("El pedido fue cancelado");
		setCancelado(true);
		setMostrarDetalle(false);
		console.log("Componente desmontado correctamente");
	};

	return (
		<>
			<h2>Detalle de su pedido:</h2>
			{!mostrarDetalle ? (
				<button type="button" onClick={() => setMostrarDetalle(true)}>
					Mostrar detalle
				</button>
			) : null}
			{mostrarDetalle ? (
				<DetallePedido handleButtonCancel={handleButtonCancel} cancelado={cancelado} />
			) : null}
		</>
	);
}

export default App;
