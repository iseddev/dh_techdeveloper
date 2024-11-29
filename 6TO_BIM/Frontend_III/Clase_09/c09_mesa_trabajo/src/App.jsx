import { useEffect, useState } from "react";

import DetallePedido from "./DetallePedido";

import "./App.css";

function App() {
	const [cancelado, setCancelado] = useState(false);
	const [mostrarDetalle, setMostrarDetalle] = useState(false);

	useEffect(() => {
		const timer = setTimeout(() => {
			if (!cancelado) {
				setMostrarDetalle(true);
				console.log("Componente montado correctamente");
			}
		}, 2000);
		return () => clearTimeout(timer);
	}, [cancelado]);

	const handleButtonCancel = () => {
		alert("El pedido fue cancelado");
		setCancelado(true);
		setMostrarDetalle(false);
		console.log("Componente desmontado correctamente");
	};

	return (
		<>
			<h2>Detalle de su pedido:</h2>
			{mostrarDetalle ? <DetallePedido handleButtonCancel={handleButtonCancel} /> : null}
		</>
	);
}

export default App;
