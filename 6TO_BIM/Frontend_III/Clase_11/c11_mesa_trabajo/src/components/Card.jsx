const Card = ({ data, onClick }) => {
	return (
		<div className="card" onClick={onClick}>
			<h3>{data.title}</h3>
			<p>{data.short_description}</p>
			<img src={data.thumbnail} alt={data.title} />
		</div>
	);
};

export default Card;
