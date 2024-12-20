const DetallePedido = ({ handleButtonCancel, cancelado }) => {
	return (
		<div>
			{cancelado ? (
				<i>Cargando información del pedido...</i>
			) : (
				<>
					<ul>
						<li>2 x Pizza Hawaiana</li>
						<li>3 x Empanadas</li>
						<li>4 x Gaseosa</li>
					</ul>
					<button type="button" onClick={handleButtonCancel}>
						Cancelar pedido
					</button>
				</>
			)}
		</div>
	);
};

export default DetallePedido;
