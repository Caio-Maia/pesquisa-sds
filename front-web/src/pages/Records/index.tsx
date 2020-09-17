import React from 'react'
import './styles.css'

const Records = () => (
    <div className="page-container">
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
                <tr>
                    <td>12/06/2020</td>
                    <td>Darigoberto</td>
                    <td>123</td>
                    <td>ps4</td>
                    <td>ação</td>
                    <td>Relampago marquinhos</td>
                </tr>
            </tbody>
        </table>
    </div>
);

export default Records;