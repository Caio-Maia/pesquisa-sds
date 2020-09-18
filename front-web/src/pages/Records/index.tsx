import React, { useEffect, useState } from 'react'
import axios from 'axios'
import './styles.css'
import { RecordResponse } from './types'
import { formatDate } from './helpers'
import Pagination from './Pagination'
import { Link } from 'react-router-dom'

const BASE_URL = 'http://localhost:8080'

const Records = () => {

    const [ recordsResponse, setRecordResponse ] = useState<RecordResponse>();
    const [activePage, setActivePage] = useState(0);

    useEffect(() => {
        axios.get(`${BASE_URL}/records?linesPerPage=12&page=${activePage}`)
            .then(response => setRecordResponse(response.data))
    }, [activePage])

    const handlerPageChange = (index: number) => {
        setActivePage(index);
    }

    return (
        <div className="page-container">
            <div className="filters-container records-actions">
                <Link to="/charts">
                    <button className="action-filters">
                    GRAFICOSSS
                    </button>
                </Link>
            </div>
            <table className="records-table" cellPadding="0" cellSpacing="0">
                <thead>
                    <tr>
                        <th>INSTANTE</th>
                        <th>NOME</th>
                        <th>IDADE</th>
                        <th>PLATAFORMA</th>
                        <th>GÊNERO</th>
                        <th>TÍTULO DO GAME</th>
                    </tr>
                </thead>
                <tbody>
                    {recordsResponse?.content.map(record => 
                    <tr key={record.id} >
                        <td>{formatDate(record.moment)}</td>
                        <td>{record.name}</td>
                        <td>{record.age}</td>
                        <td className="text-secondary">{record.gamePlatform}</td>
                        <td>{record.genreName}</td>
                        <td className="text-primary">{record.gameTitle}</td>
                    </tr>)}
                </tbody>
            </table>
            <Pagination 
                activePage={activePage} 
                goToPage={handlerPageChange}
                totalPages={recordsResponse?.totalPages}
            />
        </div>
    );
}

export default Records;