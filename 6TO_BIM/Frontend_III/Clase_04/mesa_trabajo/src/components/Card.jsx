import styles from "./Card.module.css";

export const Card = ({ id, description, imgURL, price }) => {
	return (
		<li key={id} className={styles.cardWrapper}>
			<div className={styles.card}>
				<h2 className={styles.cardTitle}>{description}</h2>
				<img className={styles.cardImage} src={imgURL} alt={description} />
				<h3 className={styles.cardPrice}>{price}</h3>
			</div>
		</li>
	);
};
