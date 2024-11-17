// const Saludo = (props) => {
// 	return (
// 		<>
// 			<h1>
// 				{props.children}
// 				<span>{props.name}</span>
// 			</h1>
// 		</>
// 	);
// };

// Crear un componente usando prop children y fragment, y enviar una variable que contenga un nombre como prop e inserte un children escrito Hello. Devolver el mensaje, por ejemplo: Hello Juan. Recordemos que Hello es el children y Juan es enviado como prop.
const Saludo = ({ children, name }) => {
	return (
		<>
			{children} {name}
		</>
	);
};

export default Saludo;
