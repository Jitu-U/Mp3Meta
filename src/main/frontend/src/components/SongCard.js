import '../css/SongCard.css'
import React from 'react'

function SongCard(props) {
    return (
        <div className="card-container">

            <div className="left">

            <div className="title">
                {props.title}
            </div>
            <div className="artist">
                {props.artist}
            </div>
            <div className="composer">
                {props.composer}
            </div>
            <div className="album">
                {props.album}
            </div>

            </div>
            

            <div className="right">
                <div className="genre">
                    {props.genre}
                </div>
                <div className="release">
                    {props.year}
                </div>
                <div className="sample-rate">
                    {props.sampleRate} KHz
                </div>
                <div className="channels">
                    {props.channels}
                </div>
            </div>

        </div>
    )
}

export default SongCard