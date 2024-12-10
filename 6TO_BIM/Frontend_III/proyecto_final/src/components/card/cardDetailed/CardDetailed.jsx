import styles from "../Card.module.css";
import CardButtonFavorite from "../cardButtonFavorite/CardButtonFavorite";

const CardDetailed = ({ data }) => {
	return (
		<div className={styles.cardDetailed}>
			<CardButtonFavorite data={data} />
			<div className={styles.cardDetailed__container}>
				<div className={styles.cardDetailed__imageContainer}>
					<img className={styles.cardDetailed__image} src={data.image} alt={data.name} />
				</div>
				<div className={styles.cardDetailed__info}>
					<h2>{data.name}</h2>
					<div className={styles.cardDetailed__pills}>
						<p className={styles.cardDetailed__pill}>
							<span>Race</span> {data.race}
						</p>
						<p className={styles.cardDetailed__pill}>
							<span>Ki</span> {data.ki}
						</p>
						<p className={styles.cardDetailed__pill}>
							<span>Gender</span> {data.gender}
						</p>
						<p className={styles.cardDetailed__pill}>
							<span>Team</span> {data.affiliation}
						</p>
						<p className={styles.cardDetailed__pill}>
							<span>Description</span> {data.description}
						</p>
					</div>
				</div>
			</div>
			<div className={styles.cardDetailed__buttons}>
				<button>Previous Character</button>
				<button>Next Character</button>
			</div>
		</div>
	);
};

export default CardDetailed;
