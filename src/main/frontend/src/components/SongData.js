import React, { useEffect, useState } from 'react'
import Loader from './Loader';
import SongCard from './SongCard';
import '../css/SongData.css'

function SongData() {

  const [SongData, setSongData] = useState([]);

  useEffect(() => {
    (
      async function fetchData() {
        let data = await fetch("http://localhost:8080/api/v1/songs")
          .then(data => data.json());
        console.log(data);
        setSongData(data);
      }
    )();
  }, []);



  return (
    <div className='meta-container'>
      <div className="meta-title">
        <h1>Songs Metadata</h1>
      </div>
      <div className="cards-container">
        {
          SongData.length ? SongData.map(x => {
            return <SongCard key={x.id} title={x.title} artist={x.artist} composer={x.composer} album={x.album} genre={x.genre} year={x.releaseYear} sampleRate={x.sampleRate} channels={x.channelType}></SongCard>
          }) : <Loader />
        }
      </div>


    </div>
  )
}

export default SongData