import { Link } from "react-router-dom";

import styles from "./Card.module.css";
import CardButtonFavorite from "./cardButtonFavorite/CardButtonFavorite";

const Card = ({ data, onClick }) => {
	return (
		<div className={styles.characterCard}>
			<CardButtonFavorite />
			<div className={styles.characterCard__container}>
				<Link to={`/character/${data.id}`}>
					<img className={styles.characterCard__image} src={data.image} alt={data.name} />
				</Link>
				{/* <img className={styles.characterCard__image} src={data.image} alt={data.name} /> */}
				<div className={styles.characterCard__info}>
					<h2>{data.name}</h2>
					<p>{data.race}</p>
					<p>Ki: {data.ki}</p>
					<p>Gender: {data.gender}</p>
					<p>Team: {data.affiliation}</p>
				</div>
				<button className={styles.characterCard__button} onClick={onClick}>
					Ver detalle
				</button>
			</div>
		</div>
	);
};

export default Card;
