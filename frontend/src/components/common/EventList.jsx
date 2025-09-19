import styles from './EventList.module.scss';
import { Link } from 'react-router-dom';

const EventList = ({ eventList }) => {
    const { events, list, item, content } = styles;

    return (
        <div className={events}>
            <h1>All Diarys</h1>
            <ul className={list}>
                {eventList.map((ev) => (
                    <li
                        key={ev.diaryId}
                        className={item}>
                        <Link to={ev.diaryId.toString()}>
                            <div className={content}>
                                <h2>{ev.title}</h2>
                                <time>{ev.startDate}</time>
                            </div>
                        </Link>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default EventList;