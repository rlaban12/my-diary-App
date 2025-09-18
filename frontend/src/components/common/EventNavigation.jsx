import styles from './EventNavigation.module.scss';
import { NavLink } from 'react-router-dom';

const EventsNavigation = () => {
    const activeClassFn = ({ isActive }) => {
        return isActive ? styles.active : undefined;
    };
    return (
        <header className={styles.header}>
            <nav>
                <ul className={styles.list}>
                    <li>
                        <NavLink
                            to='/events'
                            className={activeClassFn}
                            end>
                            All Diarys
                        </NavLink>
                    </li>
                    <li>
                        <NavLink
                            to='/events/new'
                            className={activeClassFn}>
                            New Diary
                        </NavLink>
                    </li>
                </ul>
            </nav>
        </header>
    );
};

export default EventsNavigation;