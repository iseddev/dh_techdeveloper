import { Outlet, useNavigate } from "react-router-dom";

const Dashboard = () => {
	const navigate = useNavigate();

	const goToStats = () => navigate("/dashboard/stats");
	const goToProfile = () => navigate("/dashboard/profile");

	return (
		<>
			<h1>Dashboard</h1>
			<button onClick={goToStats}>Go to Stats</button>
			<button onClick={goToProfile}>Go to Profile</button>
			<Outlet />
		</>
	);
};

export default Dashboard;
