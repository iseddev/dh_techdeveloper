import ItemCounter from "../counter/ItemCounter";
import styles from "./Card.module.css";

const Card = ({ id, name, image, alt, price }) => {
	return (
		<article id={id} className={styles.cardWrapper}>
			<h2 className={styles.cardTitle}>{name}</h2>
			<img src={image} alt={alt} className={styles.cardImage} />
			<ItemCounter />
			<div>
				<p className={styles.cardPrice}>Price: ${price} USD</p>
			</div>
		</article>
	);
};

export default Card;
