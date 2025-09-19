import styles from './EventItem.module.scss';
import {Link, useSubmit} from 'react-router-dom';

const EventItem = ({ event }) => {
    const {
        'id':id,
        'title':title,
        'diary': diary,
        'start-date': date,
    } = event;

    // Form 컴포넌트 없이 action함수를 작동시키는 법
    const submit = useSubmit();

    const handleRemove = e => {
        // Form없이 action함수 트리거 - 낙관적 업데이트
        submit(null, {method:'DELETE'});
    };

    return (
        <article className={styles.event}>
            <h1>{title}</h1>
            <time>{date}</time>
            <p>{diary}</p>
            <menu className={styles.actions}>
                <Link to='edit'>Edit</Link>
                <button onClick={handleRemove}>Delete</button>
            </menu>
        </article>
    );
};

export default EventItem;