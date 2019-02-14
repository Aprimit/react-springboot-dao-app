import React from 'react'
let User = props => (
  <tr >
    <td>{props.username}</td>
    <td>{props.firstname}</td>
    <td>{props.lastname}</td>
    <td>{props.organization}</td>
    <td>{props.department}</td>
    <td>{props.designation}</td>
  </tr>
)
export default User;