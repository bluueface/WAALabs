import { Outlet } from "react-router-dom";

function Main() {
  return (
    <div className="h-screen text-white bg-gray-950 flex items-center justify-center">
      <Outlet />
    </div>
  );
}

export default Main;
