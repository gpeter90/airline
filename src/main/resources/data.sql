INSERT INTO airline.booking (pax_name,departure,itinerary) VALUES
	 ('Alice','2025-08-06 13:34:48.571','AAL→AMS→LHR→JFK→SFO'),
	 ('Cindy','2026-10-06 12:34:48.571','GVA→AMS→LHR'),
	 ('Erica','2026-01-12 06:35:48.571','ATL→AMS→AAL'),
	 ('Fred','2024-12-12 23:55:48.571','AMS→CDG→LHR')
	 ON CONFLICT DO NOTHING;
