import React from 'react'
export default class Profile extends React.Component {
    render() {
      return (
        <div>
          <p>
            {this.props.name} - {this.props.desc}
          </p>
        </div>
      );
    }
  }